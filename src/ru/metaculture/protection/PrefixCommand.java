/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.List;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class PrefixCommand
extends ChatCommand {
    public PrefixCommand() {
        super("prefix", "Change command prefix", ".prefix set <symbol>");
        this.primaryVal("set", List::of);
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        if (stringArray.length < 2 || stringArray[0] == null || !stringArray[0].equalsIgnoreCase("set")) {
            String string = this.primaryVal();
            ChatLogger.primaryVal("§cUsage: " + string);
            return;
        }
        String string = stringArray[1];
        if (string != null && string.length() > 1) {
            ChatLogger.primaryVal("§cPrefix must be a single character!");
            return;
        }
        WildClient modeVal = WildClient.primaryVal;
        if (modeVal != null) {
            modeVal.primaryVal(string);
        }
        ChatLogger.primaryVal("§aPrefix successfully changed to: §f" + string);
    }

    static {
        Loader.initialize();
    }
}

