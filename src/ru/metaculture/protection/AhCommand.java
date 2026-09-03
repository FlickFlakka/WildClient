/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_634
 */
package ru.metaculture.protection;

import java.util.Locale;
import net.minecraft.class_634;
import org.wild.module.api.Module;
import ru.metaculture.protection.SettingList;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.ModuleManager;
import ru.metaculture.protection.AhHelperModule;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.BoolSetting;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public final class AhCommand
extends ChatCommand {
    public AhCommand() {
        super("ah", "Open the general auction page with a price filter", ".ah [max price]");
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        SettingList nNnnunNVu;
        ModuleManager uVvnVvvUVUv2;
        if (AhCommand.a_.field_1724 == null || AhCommand.a_.field_1724.field_3944 == null) {
            ChatLogger.primaryVal("§c[AhHelper] Player is not connected to the server.");
            return;
        }
        if (stringArray.length == 0) {
            AhHelperModule.blockRef();
            class_634 class_6342 = AhCommand.a_.field_1724.field_3944;
            if (class_6342 != null) {
                class_6342.method_45730("ah");
            }
            return;
        }
        Long l = this.tertiaryVal(stringArray);
        if (l == null || l <= 0L) {
            ChatLogger.primaryVal("§cUsage: " + this.primaryVal());
            ChatLogger.primaryVal("§7Example: §f.ah 100 000");
            return;
        }
        if (WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null && (uVvnVvvUVUv2 = WildClient.primaryVal.secondaryVal) != null && (nNnnunNVu = uVvnVvvUVUv2.primaryVal(AhHelperModule.class)) != null && !((AhHelperModule)nNnnunNVu).enabled) {
            ((Module)nNnnunNVu).setEnabled(true);
        }
        AhHelperModule.primaryVal(l);
        class_634 class_6342 = AhCommand.a_.field_1724.field_3944;
        if (class_6342 != null) {
            class_6342.method_45730("ah");
        }
        String string = (nNnnunNVu = AhHelperModule.descRef) != null && ((BoolSetting)nNnnunNVu).tertiaryVal() ? "§aenabled" : "§eset, checkbox disabled";
        ChatLogger.primaryVal("§7[AhHelper] General filter " + string + "§7: up to §f" + this.primaryVal(l) + "$");
    }

    private Long tertiaryVal(String[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            if (string == null || !string.matches("[0-9][0-9_.,]*")) {
                return null;
            }
            stringBuilder.append(string.replaceAll("[^0-9]", ""));
        }
        if (stringBuilder.isEmpty()) {
            return null;
        }
        try {
            return Long.parseLong(stringBuilder.toString());
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private String primaryVal(long l) {
        Object[] objectArray = new Object[1];
        objectArray[0] = l;
        return String.format(Locale.ROOT, "%,d", objectArray).replace(',', ' ');
    }

    static {
        Loader.initialize();
    }
}

