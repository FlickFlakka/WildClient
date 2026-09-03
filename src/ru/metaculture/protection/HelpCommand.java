/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.ChatCommandRegistry;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class HelpCommand
extends ChatCommand {
    private final ChatCommandRegistry primaryVal;

    public HelpCommand(ChatCommandRegistry mossG) {
        super("help", "Shows the list of all commands", ".help");
        this.primaryVal = mossG;
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        ChatLogger.primaryVal("§bAvailable commands:");
        for (ChatCommand coreC : this.primaryVal.primaryVal()) {
            ChatLogger.primaryVal("\u00a77" + coreC.tertiaryVal() + " \u00a78- \u00a7f" + coreC.secondaryVal());
        }
    }

    static {
        Loader.initialize();
    }
}

