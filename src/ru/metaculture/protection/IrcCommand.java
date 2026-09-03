/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import net.minecraft.class_320;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.IrcWebSocketClient;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class IrcCommand
extends ChatCommand {
    public IrcCommand() {
        super("irc", "Sends a message to the global IRC chat", ".irc <message>");
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        IrcWebSocketClient vUUvvNUVNvNU2;
        WildClient modeVal;
        IrcWebSocketClient vUUvvNUVNvNU3;
        IrcWebSocketClient vUUvvNUVNvNU4;
        if (stringArray.length == 0) {
            ChatLogger.primaryVal("§cInvalid format. Use: .irc <message>");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            stringBuilder.append(string).append(" ");
        }
        String string = stringBuilder.toString().trim();
        WildClient nodeC = WildClient.primaryVal;
        IrcWebSocketClient vUUvvNUVNvNU5 = vUUvvNUVNvNU4 = nodeC == null ? null : nodeC.limitRef();
        if (vUUvvNUVNvNU4 == null) {
            ChatLogger.primaryVal("§c[IRC] You are not connected to the IRC server. Message not sent.");
            return;
        }
        WildClient partE = WildClient.primaryVal;
        IrcWebSocketClient vUUvvNUVNvNU6 = vUUvvNUVNvNU3 = partE == null ? null : partE.limitRef();
        if (vUUvvNUVNvNU3 == null || !vUUvvNUVNvNU3.isOpen()) {
            ChatLogger.primaryVal("§c[IRC] You are not connected to the IRC server. Message not sent.");
            return;
        }
        String string2 = null;
        class_310 class_3102 = a_;
        class_320 class_3202;
        if (class_3102 != null && (class_3202 = class_3102.method_1548()) != null) {
            string2 = class_3202.method_1676();
        }
        IrcWebSocketClient vUUvvNUVNvNU7 = vUUvvNUVNvNU2 = (modeVal = WildClient.primaryVal) == null ? null : modeVal.limitRef();
        if (vUUvvNUVNvNU2 != null) {
            vUUvvNUVNvNU2.primaryVal(string2, string);
        }
    }

    static {
        Loader.initialize();
    }
}

