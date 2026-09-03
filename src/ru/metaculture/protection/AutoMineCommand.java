/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.List;
import java.util.Locale;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.AutoMineModule;
import ru.metaculture.protection.ModuleManager;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class AutoMineCommand
extends ChatCommand {
    public AutoMineCommand() {
        super("automine", "AutoMine management", ".automine save");
        this.primaryVal("save", List::of);
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        String string;
        if (stringArray.length == 0) {
            ChatLogger.primaryVal("§cUsage: " + this.primaryVal());
            return;
        }
        String string2 = stringArray[0];
        Locale locale = Locale.ROOT;
        String string3 = string = string2 == null ? null : string2.toLowerCase(locale);
        if (string == null || !"save".equals(string)) {
            ChatLogger.primaryVal("§cUsage: " + this.primaryVal());
            return;
        }
        ModuleManager uVvnVvvUVUv2 = WildClient.primaryVal.secondaryVal;
        if (!(uVvnVvvUVUv2 instanceof ModuleManager)) {
            ChatLogger.primaryVal("§cModule manager is not initialized.");
            return;
        }
        ModuleManager uVvnVvvUVUv3 = WildClient.primaryVal.secondaryVal;
        if (uVvnVvvUVUv3 == null) {
            ChatLogger.primaryVal("§cAutoMine not found.");
            return;
        }
        AutoMineModule uUNVnVvv2 = uVvnVvvUVUv3.primaryVal(AutoMineModule.class);
        if (uUNVnVvv2 == null) {
            ChatLogger.primaryVal("§cAutoMine not found.");
            return;
        }
        uUNVnVvv2.blockRef();
    }

    static {
        Loader.initialize();
    }
}

