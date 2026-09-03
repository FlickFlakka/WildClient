/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  io.netty.bootstrap.Bootstrap
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelFuture
 *  io.netty.channel.ChannelFutureListener
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelInboundHandlerAdapter
 *  io.netty.channel.ChannelInitializer
 *  io.netty.channel.ChannelOption
 *  io.netty.channel.EventLoopGroup
 *  io.netty.channel.nio.NioEventLoopGroup
 *  io.netty.channel.socket.SocketChannel
 *  io.netty.channel.socket.nio.NioSocketChannel
 *  io.netty.handler.proxy.ProxyConnectionEvent
 *  io.netty.handler.proxy.ProxyHandler
 *  io.netty.handler.proxy.Socks4ProxyHandler
 *  io.netty.handler.proxy.Socks5ProxyHandler
 *  io.netty.util.concurrent.GenericFutureListener
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.proxy.ProxyConnectionEvent;
import io.netty.handler.proxy.ProxyHandler;
import io.netty.handler.proxy.Socks4ProxyHandler;
import io.netty.handler.proxy.Socks5ProxyHandler;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ProxyManager {
    public static final String primaryVal = "Socks4";
    public static final String secondaryVal = "Socks5";
    private static final Gson speedVal = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    private static final Pattern widthVal = Pattern.compile("(?i)(?:socks\\s*[45]|so+cks?\\s*[45])?\\s*(?:://)?([A-Za-z0-9._~%+\\-]+):([^\\s@]+)@([A-Za-z0-9.\\-]+):(\\d{1,5})");
    private static final Pattern chunkVal = Pattern.compile("(?i)(?:socks\\s*[45]|so+cks?\\s*[45])?\\s*(?:://)?([A-Za-z0-9.\\-]+):(\\d{1,5}):([^\\s:]+):([^\\s]+)");
    private static final Pattern blockRef = Pattern.compile("(?i)(?<![A-Za-z0-9._:-])([A-Za-z0-9.\\-]+):(\\d{1,5})(?![A-Za-z0-9._:-])");
    public static volatile String tertiaryVal = "";
    public static volatile String marginVal = "";
    public static volatile String weightVal = "Socks5";
    public static volatile String paramVal = "";
    public static volatile String extraVal = "";
    public static volatile boolean limitVal = false;
    private static volatile boolean holderVal;

    private ProxyManager() {
    }

    public static synchronized void primaryVal() {
        if (holderVal) {
            return;
        }
        holderVal = true;
        File file = ProxyManager.weightVal();
        if (file == null || !file.exists() || !file.isFile()) {
            return;
        }
        try (FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);){
            JsonElement jsonElement = JsonParser.parseReader((Reader)fileReader);
            if (jsonElement == null || !jsonElement.isJsonObject()) {
                return;
            }
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            limitVal = ProxyManager.primaryVal(jsonObject, "enabled", false);
            weightVal = ProxyManager.secondaryVal(ProxyManager.primaryVal(jsonObject, "type", secondaryVal));
            tertiaryVal = ProxyManager.tertiaryVal(ProxyManager.primaryVal(jsonObject, "host", ProxyManager.primaryVal(jsonObject, "ip", "")));
            marginVal = ProxyManager.weightVal(ProxyManager.primaryVal(jsonObject, "port", ""));
            paramVal = ProxyManager.chunkVal(ProxyManager.primaryVal(jsonObject, "username", ""));
            extraVal = ProxyManager.chunkVal(ProxyManager.primaryVal(jsonObject, "password", ""));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static synchronized void secondaryVal() {
        holderVal = true;
        try {
            File file = ProxyManager.weightVal();
            if (file == null) {
                return;
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("enabled", Boolean.valueOf(limitVal));
            jsonObject.addProperty("type", ProxyManager.secondaryVal(weightVal));
            jsonObject.addProperty("host", ProxyManager.tertiaryVal(tertiaryVal));
            jsonObject.addProperty("port", ProxyManager.weightVal(marginVal));
            jsonObject.addProperty("username", ProxyManager.chunkVal(paramVal));
            jsonObject.addProperty("password", ProxyManager.chunkVal(extraVal));
            ProxyManager.primaryVal(file, speedVal.toJson((JsonElement)jsonObject).getBytes(StandardCharsets.UTF_8));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static synchronized void primaryVal(WildClient modeVal) {
        if (modeVal == null) {
            return;
        }
        holderVal = true;
        limitVal = modeVal.enabled();
        weightVal = ProxyManager.secondaryVal(modeVal.type());
        tertiaryVal = ProxyManager.tertiaryVal(modeVal.host());
        marginVal = ProxyManager.weightVal(modeVal.port());
        paramVal = ProxyManager.chunkVal(modeVal.username()).trim();
        extraVal = ProxyManager.chunkVal(modeVal.password());
        ProxyManager.secondaryVal();
    }

    public static WildClient tertiaryVal() {
        ProxyManager.primaryVal();
        return new WildClient(limitVal, ProxyManager.secondaryVal(weightVal), ProxyManager.tertiaryVal(tertiaryVal), ProxyManager.weightVal(marginVal), ProxyManager.chunkVal(paramVal).trim(), ProxyManager.chunkVal(extraVal));
    }

    public static ProxyHandler marginVal() {
        return ProxyManager.secondaryVal(ProxyManager.tertiaryVal());
    }

    public static ProxyHandler secondaryVal(WildClient modeVal) {
        WildClient nodeC = ProxyManager.tertiaryVal(modeVal);
        if (!nodeC.enabled() || ProxyManager.primaryVal(nodeC, true) != null) {
            return null;
        }
        InetSocketAddress inetSocketAddress = new InetSocketAddress(nodeC.host(), nodeC.portInt());
        if (nodeC.isSocks4()) {
            String string = ProxyManager.limitVal(nodeC.username());
            return string == null ? new Socks4ProxyHandler((SocketAddress)inetSocketAddress) : new Socks4ProxyHandler((SocketAddress)inetSocketAddress, string);
        }
        String string = ProxyManager.limitVal(nodeC.username());
        return string == null ? new Socks5ProxyHandler((SocketAddress)inetSocketAddress) : new Socks5ProxyHandler((SocketAddress)inetSocketAddress, string, nodeC.password());
    }

    public static CompletableFuture<VvunVVUvUNnv> primaryVal(WildClient modeVal, String string, int n, final int n2) {
        final WildClient nodeC = ProxyManager.tertiaryVal(modeVal).withEnabled(true);
        String string2 = ProxyManager.primaryVal(nodeC, true);
        if (string2 != null) {
            return CompletableFuture.completedFuture(new VvunVVUvUNnv(false, 0L, string2));
        }
        final CompletableFuture<VvunVVUvUNnv> completableFuture = new CompletableFuture<VvunVVUvUNnv>();
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup(1, runnable -> {
            Thread thread = new Thread(runnable, "Wild Proxy Test");
            thread.setDaemon(true);
            return thread;
        });
        final long l = System.nanoTime();
        try {
            Bootstrap bootstrap = (Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((EventLoopGroup)nioEventLoopGroup)).channel(NioSocketChannel.class)).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, n2)).handler((ChannelHandler)new ChannelInitializer<SocketChannel>(){

                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ProxyHandler proxyHandler = ProxyManager.secondaryVal(nodeC);
                    if (proxyHandler == null) {
                        throw new IllegalStateException("Proxy config is invalid");
                    }
                    proxyHandler.setConnectTimeoutMillis((long)n2);
                    socketChannel.pipeline().addFirst("wild_proxy_test", (ChannelHandler)proxyHandler);
                    socketChannel.pipeline().addLast("wild_proxy_result", (ChannelHandler)new ChannelInboundHandlerAdapter(){

                        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
                            if (object instanceof ProxyConnectionEvent) {
                                long l2 = Math.max(1L, (System.nanoTime() - l) / 1000000L);
                                completableFuture.complete(new VvunVVUvUNnv(true, l2, "OK"));
                                channelHandlerContext.close();
                                nioEventLoopGroup.shutdownGracefully();
                                return;
                            }
                            super.userEventTriggered(channelHandlerContext, object);
                        }

                        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {
                            long l2 = Math.max(1L, (System.nanoTime() - l) / 1000000L);
                            completableFuture.complete(new VvunVVUvUNnv(false, l2, ProxyManager.primaryVal(throwable)));
                            channelHandlerContext.close();
                            nioEventLoopGroup.shutdownGracefully();
                        }

                        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
                            long l2 = Math.max(1L, (System.nanoTime() - l) / 1000000L);
                            completableFuture.complete(new VvunVVUvUNnv(false, l2, "Connection closed"));
                            nioEventLoopGroup.shutdownGracefully();
                            super.channelInactive(channelHandlerContext);
                        }
                    });
                }
            });
            ChannelFuture channelFuture = bootstrap.connect((SocketAddress)InetSocketAddress.createUnresolved(string, n));
            channelFuture.addListener((GenericFutureListener)((ChannelFutureListener)arg_0 -> ProxyManager.primaryVal(l, completableFuture, (EventLoopGroup)nioEventLoopGroup, arg_0)));
            nioEventLoopGroup.schedule(() -> ProxyManager.primaryVal(completableFuture, n2, channelFuture, (EventLoopGroup)nioEventLoopGroup), (long)n2 + 1000L, TimeUnit.MILLISECONDS);
        }
        catch (Throwable throwable) {
            long l2 = Math.max(1L, (System.nanoTime() - l) / 1000000L);
            completableFuture.complete(new VvunVVUvUNnv(false, l2, ProxyManager.primaryVal(throwable)));
            nioEventLoopGroup.shutdownGracefully();
        }
        return completableFuture;
    }

    public static String primaryVal(WildClient modeVal, boolean bl) {
        WildClient nodeC = ProxyManager.tertiaryVal(modeVal);
        if (!bl && !nodeC.enabled() && nodeC.host().isBlank() && nodeC.port().isBlank()) {
            return null;
        }
        if (nodeC.host().isBlank()) {
            return "Proxy host is empty";
        }
        if (!ProxyManager.marginVal(nodeC.host())) {
            return "Proxy host has invalid characters";
        }
        int n = ProxyManager.extraVal(nodeC.port());
        if (n <= 0) {
            return "Proxy port is invalid";
        }
        if (nodeC.isSocks5() && !nodeC.password().isBlank() && nodeC.username().isBlank()) {
            return "SOCKS5 username is empty";
        }
        return null;
    }

    public static cursorVal primaryVal(String string) {
        String string2 = ProxyManager.chunkVal(string).trim();
        if (string2.isEmpty()) {
            return cursorVal.empty();
        }
        String string3 = ProxyManager.primaryVal(string2, secondaryVal);
        Matcher matcher = widthVal.matcher(string2);
        if (matcher.find()) {
            return new cursorVal(string3, matcher.group(3), matcher.group(4), ProxyManager.widthVal(matcher.group(1)), ProxyManager.widthVal(matcher.group(2)));
        }
        Matcher matcher2 = chunkVal.matcher(string2);
        if (matcher2.find()) {
            return new cursorVal(string3, matcher2.group(1), matcher2.group(2), ProxyManager.widthVal(matcher2.group(3)), ProxyManager.widthVal(matcher2.group(4)));
        }
        String string4 = "";
        String string5 = "";
        String string6 = "";
        String string7 = "";
        String[] stringArray = string2.replace("\r", "").split("\n");
        Object object = stringArray;
        int n = ((String[])object).length;
        for (int i = 0; i < n; ++i) {
            String string8;
            String string9;
            block25: {
                Object object2;
                block24: {
                    block23: {
                        block22: {
                            block21: {
                                block20: {
                                    Object object3 = ((String[])object)[i];
                                    String string10 = ((String)object3).trim();
                                    string9 = string10.toLowerCase(Locale.ROOT);
                                    string8 = ProxyManager.speedVal(string10);
                                    if (string8.isBlank()) continue;
                                    matcher2 = chunkVal.matcher(string8);
                                    if (matcher2.find()) {
                                        return new cursorVal(string3, matcher2.group(1), matcher2.group(2), ProxyManager.widthVal(matcher2.group(3)), ProxyManager.widthVal(matcher2.group(4)));
                                    }
                                    if (string9.contains("wexside")) {
                                        object2 = ProxyManager.primaryVal(string8);
                                        if (!((cursorVal)object2).host().isBlank()) {
                                            return ((cursorVal)object2).withType(string3);
                                        }
                                    }
                                    if (string9.contains("login") || string9.contains("username")) break block20;
                                    if (!string9.contains("login")) break block21;
                                }
                                string6 = string8.trim();
                                continue;
                            }
                            if (string9.contains("password")) break block22;
                            if (!string9.contains("password")) break block23;
                        }
                        string7 = string8.trim();
                        continue;
                    }
                    if (string9.contains("port") || string9.contains("port")) {
                        string5 = ProxyManager.weightVal(string8);
                        continue;
                    }
                    if (string9.contains("proxy")) break block24;
                    if (!string9.contains("proxy")) break block25;
                }
                if (!((Matcher)(object2 = blockRef.matcher(string8))).find()) continue;
                string4 = ((Matcher)object2).group(1);
                string5 = ((Matcher)object2).group(2);
                continue;
            }
            if (!string9.matches(".*\\bip\\b.*")) continue;
            string4 = ProxyManager.tertiaryVal(string8);
        }
        if ((string4.isBlank() || string5.isBlank()) && ((Matcher)(object = blockRef.matcher(string2))).find()) {
            string4 = ((Matcher)object).group(1);
            string5 = ((Matcher)object).group(2);
        }
        if (string6.isBlank() && string7.isBlank()) {
            if (!string4.isBlank() && string2.contains("@") && (matcher = widthVal.matcher(string2)).find()) {
                string6 = ProxyManager.widthVal(matcher.group(1));
                string7 = ProxyManager.widthVal(matcher.group(2));
            }
        }
        return new cursorVal(string3, ProxyManager.tertiaryVal(string4), ProxyManager.weightVal(string5), string6, string7);
    }

    public static String secondaryVal(String string) {
        String string2 = ProxyManager.chunkVal(string).trim().toLowerCase(Locale.ROOT).replace(" ", "");
        if (string2.contains("4")) {
            return primaryVal;
        }
        return secondaryVal;
    }

    private static String primaryVal(String string, String string2) {
        String string3;
        block5: {
            block4: {
                string3 = ProxyManager.chunkVal(string).toLowerCase(Locale.ROOT).replace(" ", "");
                if (string3.contains("socks4") || string3.contains("sock4")) break block4;
                if (!string3.contains("soock4")) break block5;
            }
            return primaryVal;
        }
        if (string3.contains("socks5") || string3.contains("sock5") || string3.contains("soock5")) {
            return secondaryVal;
        }
        return ProxyManager.secondaryVal(string2);
    }

    private static WildClient tertiaryVal(WildClient modeVal) {
        if (modeVal == null) {
            return new WildClient(false, secondaryVal, "", "", "", "");
        }
        return new WildClient(modeVal.enabled(), ProxyManager.secondaryVal(modeVal.type()), ProxyManager.tertiaryVal(modeVal.host()), ProxyManager.weightVal(modeVal.port()), ProxyManager.chunkVal(modeVal.username()).trim(), ProxyManager.chunkVal(modeVal.password()));
    }

    private static String tertiaryVal(String string) {
        int n;
        int n2;
        int n3;
        String string2 = ProxyManager.chunkVal(string).trim();
        int n4 = string2.indexOf("://");
        if (n4 >= 0) {
            string2 = string2.substring(n4 + 3);
        }
        if ((n3 = string2.lastIndexOf(64)) >= 0 && n3 + 1 < string2.length()) {
            string2 = string2.substring(n3 + 1);
        }
        if ((n2 = string2.indexOf(47)) >= 0) {
            string2 = string2.substring(0, n2);
        }
        if (string2.startsWith("[") && (n = string2.indexOf(93)) > 0) {
            return string2.substring(1, n).trim();
        }
        n = string2.lastIndexOf(58);
        if (n > 0 && string2.indexOf(58) == n && ProxyManager.paramVal(string2.substring(n + 1))) {
            string2 = string2.substring(0, n);
        }
        return string2.trim();
    }

    private static boolean marginVal(String string) {
        String string2 = ProxyManager.chunkVal(string);
        if (string2.length() > 255) {
            return false;
        }
        for (int i = 0; i < string2.length(); ++i) {
            char c = string2.charAt(i);
            if (Character.isLetterOrDigit(c) || c == '.') continue;
            if (c == '-' || c == '_' || c == ':') continue;
            return false;
        }
        return true;
    }

    private static String weightVal(String string) {
        String string2 = ProxyManager.chunkVal(string).trim();
        StringBuilder stringBuilder = new StringBuilder(5);
        for (int i = 0; i < string2.length() && stringBuilder.length() < 5; ++i) {
            char c = string2.charAt(i);
            if (c < '0') continue;
            if (c > '9') continue;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static boolean paramVal(String string) {
        String string2;
        block4: {
            block3: {
                string2 = ProxyManager.chunkVal(string).trim();
                if (string2.isEmpty()) break block3;
                if (string2.length() <= 5) break block4;
            }
            return false;
        }
        for (int i = 0; i < string2.length(); ++i) {
            char c = string2.charAt(i);
            if (c >= '0' && c <= '9') continue;
            return false;
        }
        return true;
    }

    static int extraVal(String string) {
        try {
            int n = Integer.parseInt(ProxyManager.chunkVal(string).trim());
            return n > 0 && n <= 65535 ? n : -1;
        }
        catch (Throwable throwable) {
            return -1;
        }
    }

    private static String limitVal(String string) {
        String string2 = ProxyManager.chunkVal(string).trim();
        return string2.isEmpty() ? null : string2;
    }

    private static String speedVal(String string) {
        int n;
        block3: {
            block2: {
                n = string.indexOf(58);
                if (n < 0) break block2;
                if (n + 1 < string.length()) break block3;
            }
            return "";
        }
        return string.substring(n + 1).trim();
    }

    private static String widthVal(String string) {
        String string2 = ProxyManager.chunkVal(string);
        try {
            return URLDecoder.decode(string2.replace("+", "%2B"), StandardCharsets.UTF_8);
        }
        catch (Throwable throwable) {
            return string2;
        }
    }

    static String primaryVal(Throwable throwable) {
        for (Throwable throwable2 = throwable; throwable2 != null; throwable2 = throwable2.getCause()) {
            String string = throwable2.getMessage();
            if (string == null || string.isBlank()) continue;
            String string2 = string.replace('\n', ' ').replace('\r', ' ').trim();
            String string3 = string2.toLowerCase(Locale.ROOT);
            if (string3.contains("authstatus") || string3.contains("authentication")) {
                return "SOCKS5 auth rejected: check login/password";
            }
            return string2;
        }
        return throwable == null ? "Unknown error" : throwable.getClass().getSimpleName();
    }

    private static File weightVal() {
        if (ru.metaculture.protection.WildClient.primaryVal == null) {
            return null;
        }
        if (ru.metaculture.protection.WildClient.primaryVal.paramVal != null) {
            return new File(ru.metaculture.protection.WildClient.primaryVal.paramVal, "proxy.json");
        }
        return null;
    }

    private static void primaryVal(File file, byte[] byArray) throws Exception {
        Path path = file.toPath();
        Path path2 = path.getParent();
        if (path2 != null) {
            Files.createDirectories(path2, new FileAttribute[0]);
        }
        Path path3 = path.resolveSibling(String.valueOf(path.getFileName()) + ".tmp");
        try (FileChannel fileChannel = FileChannel.open(path3, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);){
            ByteBuffer byteBuffer = ByteBuffer.wrap(byArray);
            while (byteBuffer.hasRemaining()) {
                fileChannel.write(byteBuffer);
            }
            fileChannel.force(true);
        }
        try {
            Files.move(path3, path, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        }
        catch (AtomicMoveNotSupportedException atomicMoveNotSupportedException) {
            Files.move(path3, path, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String primaryVal(JsonObject jsonObject, String string, String string2) {
        try {
            String string3;
            JsonElement jsonElement = jsonObject.get(string);
            if (jsonElement != null && !jsonElement.isJsonNull()) {
                string3 = jsonElement.getAsString();
                return string3;
            }
            string3 = string2;
            return string3;
        }
        catch (Throwable throwable) {
            return string2;
        }
    }

    private static boolean primaryVal(JsonObject jsonObject, String string, boolean bl) {
        try {
            JsonElement jsonElement = jsonObject.get(string);
            return jsonElement == null || jsonElement.isJsonNull() ? bl : jsonElement.getAsBoolean();
        }
        catch (Throwable throwable) {
            return bl;
        }
    }

    private static String chunkVal(String string) {
        return string == null ? "" : string;
    }

    private static /* synthetic */ void primaryVal(CompletableFuture completableFuture, int n, ChannelFuture channelFuture, EventLoopGroup eventLoopGroup) {
        if (completableFuture.complete(new VvunVVUvUNnv(false, n, "Timed out"))) {
            try {
                channelFuture.channel().close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            eventLoopGroup.shutdownGracefully();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static /* synthetic */ void primaryVal(long l, CompletableFuture completableFuture, EventLoopGroup eventLoopGroup, ChannelFuture channelFuture) throws Exception {
        if (!channelFuture.isSuccess()) {
            long l2 = Math.max(1L, (System.nanoTime() - l) / 1000000L);
            try {
                completableFuture.complete(new VvunVVUvUNnv(false, l2, ProxyManager.primaryVal(channelFuture.cause())));
            }
            catch (Throwable throwable) {
                try {
                    channelFuture.channel().close();
                }
                catch (Throwable throwable2) {
                }
                eventLoopGroup.shutdownGracefully();
                throw throwable;
            }
            try {
                channelFuture.channel().close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            eventLoopGroup.shutdownGracefully();
        }
    }

    public record WildClient(boolean enabled, String type, String host, String port, String username, String password) {
        public boolean isSocks4() {
            return ProxyManager.primaryVal.equals(ProxyManager.secondaryVal(this.type));
        }

        public boolean isSocks5() {
            return !this.isSocks4();
        }

        public int portInt() {
            return ProxyManager.extraVal(this.port);
        }

        public WildClient withEnabled(boolean bl) {
            return new WildClient(bl, this.type, this.host, this.port, this.username, this.password);
        }
    }

    public record VvunVVUvUNnv(boolean success, long millis, String message) {
    }

    public record cursorVal(String type, String host, String port, String username, String password) {
        public static cursorVal empty() {
            return new cursorVal(ProxyManager.secondaryVal, "", "", "", "");
        }

        public cursorVal withType(String string) {
            return new cursorVal(ProxyManager.secondaryVal(string), this.host, this.port, this.username, this.password);
        }
    }
}

