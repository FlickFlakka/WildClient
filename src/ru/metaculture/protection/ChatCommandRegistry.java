/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;
import ru.metaculture.protection.MacroCommand;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.UuuNvUuUnu;
import ru.metaculture.protection.UvVnvNvnNUu;
import ru.metaculture.protection.AiCommand;
import ru.metaculture.protection.VvuuvuNVvvU;
import ru.metaculture.protection.CreeperFarmCommand;
import ru.metaculture.protection.ConfigCommand;
import ru.metaculture.protection.AhSearchCommand;
import ru.metaculture.protection.RejoinAnarchyCommand;
import ru.metaculture.protection.TelegramCommand;
import ru.metaculture.protection.AhCommand;
import ru.metaculture.protection.CocoaFarmCommand;
import ru.metaculture.protection.PrefixCommand;
import ru.metaculture.protection.GpsCommand;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.ChorusFarmCommand;
import ru.metaculture.protection.BotCommand;
import ru.metaculture.protection.HelpCommand;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.AutoBuyCommand;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class ChatCommandRegistry {
    private final List<ChatCommand> primaryVal = new ArrayList<ChatCommand>();

    public ChatCommandRegistry() {
        this.primaryVal(new HelpCommand(this));
        this.primaryVal(new FriendCommand());
        this.primaryVal(new PrefixCommand());
        this.primaryVal(new ConfigCommand());
        this.primaryVal(new CreeperFarmCommand());
        this.primaryVal(new CocoaFarmCommand());
        this.primaryVal(new ChorusFarmCommand());
        this.primaryVal(new TelegramCommand());
        this.primaryVal(new MacroCommand());
        this.primaryVal(new GpsCommand());
        this.primaryVal(new VvuuvuNVvvU());
        this.primaryVal(new AutoBuyCommand());
        this.primaryVal(new AhCommand());
        this.primaryVal(new AhSearchCommand());
        this.primaryVal(new RejoinAnarchyCommand());
        this.primaryVal(new UvVnvNvnNUu());
        this.primaryVal(new AiCommand());
        this.primaryVal(new BotCommand());
        this.primaryVal(new UuuNvUuUnu());
    }

    @Compile
    public void primaryVal(ChatCommand coreC) {
        this.primaryVal.add(coreC);
        EventManager.register(coreC);
    }

    @Compile
    public void primaryVal(String string) {
        String string2 = WildClient.primaryVal.paramRef();
        if (!string.startsWith(string2)) {
            return;
        }
        String[] stringArray = string.substring(string2.length()).split(" ");
        String string3 = stringArray[0];
        if (string3.equalsIgnoreCase("ah.search")) {
            string3 = "ahsearch";
        }
        String[] stringArray2 = new String[stringArray.length - 1];
        System.arraycopy(stringArray, 1, stringArray2, 0, stringArray2.length);
        for (ChatCommand coreC : this.primaryVal) {
            if (coreC == null || !coreC.primaryVal().equalsIgnoreCase(string3)) continue;
            coreC.secondaryVal(stringArray2);
            return;
        }
        ChatLogger.primaryVal("§cUnknown command. Type §7.help §cfor the list.");
    }

    public List<ChatCommand> primaryVal() {
        return this.primaryVal;
    }

    static {
        Loader.initialize();
    }
}

