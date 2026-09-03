/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.List;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.AutoBuyModule;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class AutoBuyCommand
extends ChatCommand {
    public AutoBuyCommand() {
        super("autobuy", "AutoBuy management", ".autobuy <ignore/unignore/list/clear> [name]");
        this.primaryVal("ignore", this::extraVal);
        this.primaryVal("add", this::extraVal);
        this.primaryVal("unignore", AutoBuyModule::holderVal);
        this.primaryVal("remove", AutoBuyModule::holderVal);
        this.primaryVal("list", List::of);
        this.primaryVal("clear", List::of);
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        if (stringArray.length == 0) {
            this.paramVal();
            return;
        }
        switch (stringArray[0].toLowerCase()) {
            case "add": 
            case "ignore": {
                this.tertiaryVal(stringArray);
                break;
            }
            case "del": 
            case "remove": 
            case "unignore": {
                this.marginVal(stringArray);
                break;
            }
            case "list": {
                this.marginVal();
                break;
            }
            case "clear": {
                this.weightVal();
                break;
            }
            default: {
                this.paramVal();
            }
        }
    }

    private void tertiaryVal(String[] stringArray) {
        String string;
        block6: {
            block5: {
                string = this.weightVal(stringArray);
                if (string == null) break block5;
                if (!string.isBlank()) break block6;
            }
            ChatLogger.primaryVal("§cSpecify a player's nickname: §f.autobuy ignore Nick");
            return;
        }
        if (AutoBuyModule.marginVal(string)) {
            ChatLogger.primaryVal("§e[AutoBuy] Player is already ignored: §f" + string);
            return;
        }
        if (AutoBuyModule.secondaryVal(string)) {
            this.limitVal();
            ChatLogger.primaryVal("§a[AutoBuy] Player added to ignore: §f" + string);
            return;
        }
        ChatLogger.primaryVal("§c[AutoBuy] Invalid nickname.");
    }

    private void marginVal(String[] stringArray) {
        String string = this.weightVal(stringArray);
        if (string == null || string.isBlank()) {
            ChatLogger.primaryVal("§cSpecify a player's nickname: §f.autobuy unignore Nick");
            return;
        }
        if (AutoBuyModule.tertiaryVal(string)) {
            this.limitVal();
            ChatLogger.primaryVal("§a[AutoBuy] Player removed from ignore: §f" + string);
        } else {
            ChatLogger.primaryVal("§e[AutoBuy] Player not found in ignore: §f" + string);
        }
    }

    private void marginVal() {
        List<String> list = AutoBuyModule.holderVal();
        if (list.isEmpty()) {
            ChatLogger.primaryVal("§7[AutoBuy] Seller ignore list is empty.");
            return;
        }
        ChatLogger.primaryVal("§f[AutoBuy] Ignored sellers (§7" + list.size() + "\u00a7f): \u00a77" + String.join((CharSequence)", ", list));
    }

    private void weightVal() {
        if (AutoBuyModule.holderVal().isEmpty()) {
            ChatLogger.primaryVal("§7[AutoBuy] Seller ignore list is already empty.");
            return;
        }
        AutoBuyModule.blockRef();
        this.limitVal();
        ChatLogger.primaryVal("§a[AutoBuy] Seller ignore list cleared.");
    }

    private void paramVal() {
        ChatLogger.primaryVal("§cUsage: " + this.tertiaryVal());
        ChatLogger.primaryVal("§7Example: §f.autobuy ignore QWEERZIK");
    }

    private String weightVal(String[] stringArray) {
        if (stringArray.length < 2) {
            return null;
        }
        if ("+".equals(stringArray[1])) {
            return stringArray.length >= 3 ? stringArray[2] : null;
        }
        return stringArray[1];
    }

    private List<String> extraVal() {
        if (a_.method_1562() == null) {
            return List.of();
        }
        return a_.method_1562().method_2880().stream().map(class_6402 -> class_6402.method_2966().getName()).filter(string -> string != null && !string.isBlank()).toList();
    }

    private void limitVal() {
        if (WildClient.primaryVal != null) {
            if (WildClient.primaryVal.holderVal != null) {
                WildClient.primaryVal.holderVal.tertiaryVal();
            }
        }
    }

    static {
        Loader.initialize();
    }
}

