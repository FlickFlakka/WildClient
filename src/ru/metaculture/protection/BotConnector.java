/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelFuture
 *  net.minecraft.class_2535
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2598
 *  net.minecraft.class_2896
 *  net.minecraft.class_2915
 *  net.minecraft.class_310
 *  net.minecraft.class_6368
 *  net.minecraft.class_6370
 *  net.minecraft.class_639
 */
package ru.metaculture.protection;

import io.netty.channel.ChannelFuture;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import net.minecraft.class_2535;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2598;
import net.minecraft.class_2896;
import net.minecraft.class_2915;
import net.minecraft.class_310;
import net.minecraft.class_6368;
import net.minecraft.class_6370;
import net.minecraft.class_639;
import ru.metaculture.protection.NvuvVnuNuvUv;
import ru.metaculture.protection.HeadlessBotHostManager;
import ru.metaculture.protection.HeadlessBotSession;
import ru.metaculture.protection.ChatLogger;

public final class BotConnector {
    private static final Pattern primaryVal = Pattern.compile("[A-Za-z0-9_]{1,16}");

    private BotConnector() {
    }

    public static boolean primaryVal(String string, String string2) {
        string = string == null ? "" : string.trim();
        string2 = string2 == null ? "" : string2.trim();
        if (!primaryVal.matcher(string).matches()) {
            BotConnector.tertiaryVal(string.isEmpty() ? "?" : string, "\u00a7cnickname must contain 1-16 latin letters, digits or '_'");
            return false;
        }
        if (string2.isEmpty()) {
            BotConnector.tertiaryVal(string, "\u00a7cserver address is empty");
            return false;
        }
        if (!HeadlessBotHostManager.weightVal(string)) {
            BotConnector.tertiaryVal(string, "\u00a7ca bot with this nickname is already connecting or online");
            return false;
        }
        String string4 = string;
        String string5 = string2;
        long l = HeadlessBotHostManager.secondaryVal(string4, string5);
        if (l < 0L) {
            HeadlessBotHostManager.paramVal(string4);
            BotConnector.tertiaryVal(string4, "\u00a7ccould not start a new connection attempt");
            return false;
        }
        Thread thread = new Thread(() -> {
            Object object;
            Optional optional;
            class_639 class_6392;
            HeadlessBotSession vUNVNUnuv2;
            block22: {
                block21: {
                    block20: {
                        vUNVNUnuv2 = null;
                        if (HeadlessBotHostManager.primaryVal(string4, l, Thread.currentThread())) break block20;
                        HeadlessBotHostManager.secondaryVal(string4, l, Thread.currentThread());
                        HeadlessBotHostManager.primaryVal(string4, l);
                        return;
                    }
                    BotConnector.primaryVal(string4, l, "resolving " + string5 + " ...");
                    class_6392 = class_639.method_2950((String)string5);
                    optional = class_6370.field_33745.method_36907(class_6392);
                    if (!optional.isEmpty()) break block21;
                    String string3 = "cannot resolve address: " + string5;
                    HeadlessBotHostManager.primaryVal(string4, l, string3);
                    BotConnector.primaryVal(string4, l, "\u00a7c" + string3);
                    HeadlessBotHostManager.secondaryVal(string4, l, Thread.currentThread());
                    HeadlessBotHostManager.primaryVal(string4, l);
                    return;
                }
                if (HeadlessBotHostManager.secondaryVal(string4, l)) break block22;
                HeadlessBotHostManager.secondaryVal(string4, l, Thread.currentThread());
                HeadlessBotHostManager.primaryVal(string4, l);
                return;
            }
            try {
                object = ((class_6368)optional.get()).method_36902();
                String connectingMsg = "resolved -> " + ((InetSocketAddress)object).getHostString() + ":" + ((InetSocketAddress)object).getPort() + ", connecting ...";
                HeadlessBotHostManager.primaryVal(string4, l, HeadlessBotHostManager.cursorVal.CONNECTING, connectingMsg);
                BotConnector.primaryVal(string4, l, connectingMsg);
                boolean bl = class_310.method_1551().field_1690.method_1639();
                class_2535 class_25352 = new class_2535(class_2598.field_11942);
                vUNVNUnuv2 = new HeadlessBotSession(string4, class_25352);
                ChannelFuture channelFuture = class_2535.method_52271((InetSocketAddress)object, (boolean)bl, (class_2535)class_25352);
                while (!channelFuture.awaitUninterruptibly(100L)) {
                    if (!Thread.currentThread().isInterrupted() && HeadlessBotHostManager.secondaryVal(string4, l)) continue;
                    channelFuture.cancel(true);
                    class_25352.method_10747((class_2561)class_2561.method_43470((String)"Bot connection cancelled"));
                    return;
                }
                if (!channelFuture.isSuccess()) {
                    throw new IllegalStateException("TCP connection failed", channelFuture.cause());
                }
                if (!HeadlessBotHostManager.secondaryVal(string4, l)) {
                    class_25352.method_10747((class_2561)class_2561.method_43470((String)"Bot connection cancelled"));
                    return;
                }
                class_25352.method_52902(class_6392.method_2952(), class_6392.method_2954(), (class_2896)new NvuvVnuNuvUv(class_25352, vUNVNUnuv2));
                if (!HeadlessBotHostManager.primaryVal(string4, l, vUNVNUnuv2)) {
                    if (HeadlessBotHostManager.secondaryVal(string4, l)) {
                        String closedMsg = "connection closed before the login session became active";
                        HeadlessBotHostManager.primaryVal(string4, l, closedMsg);
                        BotConnector.primaryVal(string4, l, "\u00a7c" + closedMsg);
                    }
                    HeadlessBotHostManager.tertiaryVal(vUNVNUnuv2);
                    return;
                }
                HeadlessBotHostManager.primaryVal(string4, l, HeadlessBotHostManager.cursorVal.LOGIN, "Handshake sent, waiting for login ...");
                if (!HeadlessBotHostManager.secondaryVal(string4, l)) {
                    HeadlessBotHostManager.tertiaryVal(vUNVNUnuv2);
                    return;
                }
                class_25352.method_10743((class_2596)new class_2915(string4, BotConnector.primaryVal(string4)));
                BotConnector.primaryVal(string4, l, "handshake sent, waiting for login ...");
            }
            catch (Throwable throwable) {
                boolean bl = HeadlessBotHostManager.secondaryVal(string4, l);
                object = "connect error: " + throwable.getClass().getSimpleName() + ": " + BotConnector.primaryVal(throwable);
                if (bl) {
                    HeadlessBotHostManager.primaryVal(string4, l, (String)object);
                    BotConnector.primaryVal(string4, l, "\u00a7c" + (String)object);
                }
                if (vUNVNUnuv2 != null) {
                    HeadlessBotHostManager.tertiaryVal(vUNVNUnuv2);
                }
                throwable.printStackTrace();
            }
            finally {
                HeadlessBotHostManager.secondaryVal(string4, l, Thread.currentThread());
                HeadlessBotHostManager.primaryVal(string4, l);
            }
        }, "WildBot-" + string4);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    public static UUID primaryVal(String string) {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + string).getBytes(StandardCharsets.UTF_8));
    }

    static void secondaryVal(String string, String string2) {
        HeadlessBotHostManager.tertiaryVal(string, string2);
        BotConnector.tertiaryVal(string, string2);
    }

    static void primaryVal(String string, long l, String string2) {
        if (!HeadlessBotHostManager.tertiaryVal(string, l)) {
            return;
        }
        HeadlessBotHostManager.secondaryVal(string, l, string2);
        BotConnector.tertiaryVal(string, string2);
    }

    static void primaryVal(HeadlessBotSession vUNVNUnuv2, String string) {
        block3: {
            block2: {
                if (vUNVNUnuv2 == null) break block2;
                if (HeadlessBotHostManager.marginVal(vUNVNUnuv2)) break block3;
            }
            return;
        }
        HeadlessBotHostManager.tertiaryVal(vUNVNUnuv2, string);
        BotConnector.tertiaryVal(vUNVNUnuv2.primaryVal(), string);
    }

    private static void tertiaryVal(String string, String string2) {
        String string3 = "[WildBot] " + string + ": " + string2;
        System.out.println(string3.replaceAll("\u00a7.", ""));
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 != null) {
            class_3102.execute(() -> {
                try {
                    ChatLogger.primaryVal("\u00a77[Bot] \u00a7f" + string + " \u00a77\u00bb " + string2);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            });
        }
    }

    private static String primaryVal(Throwable throwable) {
        String string = throwable.getMessage();
        return string == null || string.isBlank() ? "no details" : string;
    }
}

