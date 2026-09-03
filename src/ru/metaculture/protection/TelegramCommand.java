/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.List;
import ru.metaculture.protection.AesCipherUtil;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.TelegramNotifier;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class TelegramCommand
extends ChatCommand {
    private final Gson primaryVal = new GsonBuilder().setPrettyPrinting().create();
    private final File secondaryVal;

    public TelegramCommand() {
        super("tapi", "Telegram API for sending Telegram notifications", ".tapi <token/chatid/test/clear/info/help/dir/load>");
        this.secondaryVal = new File(ru.metaculture.protection.WildClient.primaryVal.paramVal, "telegram.cfg");
        this.primaryVal("token", List::of);
        this.primaryVal("chatid", List::of);
        this.primaryVal("test", List::of);
        this.primaryVal("clear", List::of);
        this.primaryVal("info", List::of);
        this.primaryVal("help", List::of);
        this.primaryVal("dir", List::of);
        this.primaryVal("load", List::of);
        this.speedVal();
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        if (stringArray.length == 0) {
            ChatLogger.primaryVal("§cUsage: " + this.tertiaryVal());
            return;
        }
        switch (stringArray[0].toLowerCase()) {
            case "dir": {
                this.limitVal();
                break;
            }
            case "help": {
                this.extraVal();
                break;
            }
            case "info": {
                this.paramVal();
                break;
            }
            case "load": {
                this.speedVal();
                break;
            }
            case "test": {
                this.marginVal();
                break;
            }
            case "clear": {
                this.weightVal();
                break;
            }
            case "token": {
                this.tertiaryVal(stringArray);
                break;
            }
            case "chatid": {
                this.marginVal(stringArray);
                break;
            }
            default: {
                ChatLogger.primaryVal("§cUnknown subcommand.");
            }
        }
    }

    @Compile
    private void tertiaryVal(String[] stringArray) {
        if (stringArray.length < 2) {
            ChatLogger.primaryVal("§cSpecify the bot token.");
            ChatLogger.primaryVal("§7Example: §f.tapi token 7836941137:AAGSPTZ8lVbmXUX7zjjijRjs7iyCqgg7aXE");
            return;
        }
        String string = stringArray[1];
        if (!string.matches("\\d+:[A-Za-z0-9_-]+")) {
            ChatLogger.primaryVal("§cInvalid token format!");
            ChatLogger.primaryVal("§7Format: §f<numbers>:<letters and digits>");
            ChatLogger.primaryVal("§7Example: §f7836941137:AAGSPTZ8lVbmXUX7zjjijRjs7iyCqgg7aXE");
            return;
        }
        try {
            WildClient modeVal = this.widthVal();
            modeVal.primaryVal = AesCipherUtil.primaryVal(string, "gUhDvBzdE4xq5f4BxkPvxv70VY44WsuH1O6s2nZ2F9U1w9y1VVG1mXQcUfbJM2DDUCd8NvtM0L4O1t1nn8FwwAVYlChNncdagiv9UR8FpLXXF8iMAtlWY4mEnYtLHPB3");
            this.primaryVal(modeVal);
            this.secondaryVal(modeVal);
            ChatLogger.primaryVal("§aBot token successfully saved (encrypted)");
            if (modeVal.secondaryVal == null || modeVal.secondaryVal.isEmpty()) {
                ChatLogger.primaryVal("§eNow set the Chat ID: §f.tapi chatid <ID>");
            } else {
                ChatLogger.primaryVal("§aUse §f.tapi test §ato check");
            }
        }
        catch (Exception exception) {
            ChatLogger.primaryVal("§cToken encryption error.");
            exception.printStackTrace();
        }
    }

    @Compile
    private void marginVal(String[] stringArray) {
        if (stringArray.length < 2) {
            ChatLogger.primaryVal("§cSpecify a Chat ID.");
            ChatLogger.primaryVal("§7Example: §f.tapi chatid 123456789");
            ChatLogger.primaryVal("§7Or for groups: §f.tapi chatid -100123456789");
            return;
        }
        String string = stringArray[1];
        if (!string.matches("-?\\d+")) {
            ChatLogger.primaryVal("§cChat ID must be a number!");
            ChatLogger.primaryVal("§7For personal chats: §f123456789");
            ChatLogger.primaryVal("§7For groups: §f-100123456789");
            return;
        }
        try {
            WildClient modeVal = this.widthVal();
            modeVal.secondaryVal = AesCipherUtil.primaryVal(string, "gUhDvBzdE4xq5f4BxkPvxv70VY44WsuH1O6s2nZ2F9U1w9y1VVG1mXQcUfbJM2DDUCd8NvtM0L4O1t1nn8FwwAVYlChNncdagiv9UR8FpLXXF8iMAtlWY4mEnYtLHPB3");
            this.primaryVal(modeVal);
            this.secondaryVal(modeVal);
            ChatLogger.primaryVal("§aChat ID successfully saved (encrypted)");
            if (modeVal.primaryVal == null || modeVal.primaryVal.isEmpty()) {
                ChatLogger.primaryVal("§eNow set the token: §f.tapi token <token>");
            } else {
                ChatLogger.primaryVal("§aUse §f.tapi test §ato check");
            }
        }
        catch (Exception exception) {
            ChatLogger.primaryVal("§cChat ID encryption error.");
            exception.printStackTrace();
        }
    }

    @Compile
    private void marginVal() {
        if (!TelegramNotifier.primaryVal()) {
            ChatLogger.primaryVal("§cFirst set up the token and Chat ID!");
            ChatLogger.primaryVal("§7Use: §f.tapi token <token>");
            ChatLogger.primaryVal("§7Use: §f.tapi chatid <ID>");
            return;
        }
        String string = "Test message from Wild Client!\nYour Telegram API is configured correctly.";
        TelegramNotifier.primaryVal(string);
        ChatLogger.primaryVal("§aTest message sent to Telegram!");
    }

    @Compile
    private void weightVal() {
        try {
            WildClient modeVal = new WildClient();
            this.primaryVal(modeVal);
            TelegramNotifier.primaryVal("", "");
            ChatLogger.primaryVal("§cTelegram API data cleared.");
        }
        catch (Exception exception) {
            ChatLogger.primaryVal("§cError clearing data.");
        }
    }

    @Compile
    private void paramVal() {
        try {
            WildClient modeVal = this.widthVal();
            boolean bl = modeVal.primaryVal != null && !modeVal.primaryVal.isEmpty();
            boolean bl2 = modeVal.secondaryVal != null && !modeVal.secondaryVal.isEmpty();
            ChatLogger.primaryVal("§fTelegram API information:");
            ChatLogger.primaryVal(" §7Bot token: " + (bl ? "§aInstalled ✓" : "§cNot installed ✗"));
            ChatLogger.primaryVal(" \u00a77Chat ID: " + (bl2 ? "§aInstalled ✓" : "§cNot installed ✗"));
            ChatLogger.primaryVal(" §7Status: " + (TelegramNotifier.primaryVal() ? "§aReady" : "§cSetup required"));
            if (bl && bl2) {
                ChatLogger.primaryVal(" §7Use §f.tapi test §7to verify");
            } else {
                ChatLogger.primaryVal("");
                ChatLogger.primaryVal("§eHow to set up:");
                if (!bl) {
                    ChatLogger.primaryVal("§c1. Create a bot:");
                    ChatLogger.primaryVal(" §7• Find §f@BotFather §7in Telegram");
                    ChatLogger.primaryVal(" §7• Send §f/newbot");
                    ChatLogger.primaryVal(" §7• Copy the token");
                    ChatLogger.primaryVal(" §7• §f.tapi token <token>");
                    ChatLogger.primaryVal("");
                }
                if (!bl2) {
                    ChatLogger.primaryVal("§c2. Get the Chat ID:");
                    ChatLogger.primaryVal(" §a▸ Method 1 (simple):");
                    ChatLogger.primaryVal("   §7• Find §f@userinfobot §7in Telegram");
                    ChatLogger.primaryVal("   §7• Press START");
                    ChatLogger.primaryVal("   §7• Copy the number");
                    ChatLogger.primaryVal("");
                    ChatLogger.primaryVal(" §a▸ Method 2 (via bot):");
                    ChatLogger.primaryVal("   §7• Find §f@getmyid_bot");
                    ChatLogger.primaryVal("   §7• Press START");
                    ChatLogger.primaryVal("   §7• Get the Chat ID");
                    ChatLogger.primaryVal("");
                    ChatLogger.primaryVal(" §a▸ Method 3 (manual):");
                    ChatLogger.primaryVal("   §7• Message your bot");
                    ChatLogger.primaryVal("   §7• Open in a browser:");
                    ChatLogger.primaryVal("   §fhttps://api.telegram.org/bot<TOKEN>/getUpdates");
                    ChatLogger.primaryVal("   §7• Find §fchat.id §7in the JSON");
                    ChatLogger.primaryVal("");
                    ChatLogger.primaryVal(" §7Then: §f.tapi chatid <ID>");
                }
            }
        }
        catch (Exception exception) {
            ChatLogger.primaryVal("§cError getting information.");
            exception.printStackTrace();
        }
    }

    @Compile
    private void extraVal() {
        ChatLogger.primaryVal("\u00a7f\u00a7l\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
        ChatLogger.primaryVal("§e§l          HOW TO GET A CHAT ID?");
        ChatLogger.primaryVal("\u00a7f\u00a7l\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
        ChatLogger.primaryVal("");
        ChatLogger.primaryVal("§a§l▸ Method 1 - The simplest:");
        ChatLogger.primaryVal(" §71. Find the bot §f@userinfobot §7in Telegram");
        ChatLogger.primaryVal(" §72. Press §fSTART");
        ChatLogger.primaryVal(" §73. The bot will send you the Chat ID");
        ChatLogger.primaryVal(" §74. Copy the number: §f.tapi chatid <number>");
        ChatLogger.primaryVal("");
        ChatLogger.primaryVal("§a§l▸ Method 2 - Via another bot:");
        ChatLogger.primaryVal(" §7Find any of these bots:");
        ChatLogger.primaryVal(" \u00a7f\u2022 @getmyid_bot");
        ChatLogger.primaryVal(" \u00a7f\u2022 @RawDataBot");
        ChatLogger.primaryVal(" \u00a7f\u2022 @myidbot");
        ChatLogger.primaryVal(" §7Press START and get the Chat ID");
        ChatLogger.primaryVal("");
        ChatLogger.primaryVal("§a§l▸ Method 3 - Via API:");
        ChatLogger.primaryVal(" §71. Send your bot any message");
        ChatLogger.primaryVal(" §72. Open in a browser:");
        ChatLogger.primaryVal(" §fhttps://api.telegram.org/bot<YOUR_TOKEN>/getUpdates");
        ChatLogger.primaryVal(" §73. Find in the JSON: §f\"chat\":{\"id\":123456789}");
        ChatLogger.primaryVal(" §74. Use: §f.tapi chatid 123456789");
        ChatLogger.primaryVal("");
        ChatLogger.primaryVal("§c§l▸ To send to a GROUP:");
        ChatLogger.primaryVal(" §71. Add the bot to the group");
        ChatLogger.primaryVal(" §72. Write something in the group");
        ChatLogger.primaryVal(" §73. Use getUpdates (method 3)");
        ChatLogger.primaryVal(" §74. Group Chat ID starts with §f-100");
        ChatLogger.primaryVal("");
        ChatLogger.primaryVal("\u00a7f\u00a7l\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
        ChatLogger.primaryVal("§7More info: §fhttps://t.me/userinfobot");
        ChatLogger.primaryVal("\u00a7f\u00a7l\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
    }

    @Compile
    private void limitVal() {
        try {
            String string;
            File file = this.secondaryVal.getParentFile();
            if (!file.exists()) {
                file.mkdirs();
            }
            if ((string = System.getProperty("os.name").toLowerCase()).contains("win")) {
                Runtime.getRuntime().exec(new String[]{"explorer", file.getAbsolutePath()});
            } else if (string.contains("mac")) {
                Runtime.getRuntime().exec(new String[]{"open", file.getAbsolutePath()});
            } else {
                Runtime.getRuntime().exec(new String[]{"xdg-open", file.getAbsolutePath()});
            }
            ChatLogger.primaryVal("§aConfig folder opened");
        }
        catch (Exception exception) {
            ChatLogger.primaryVal("§cFailed to open the folder.");
        }
    }

    @Compile
    private void speedVal() {
        WildClient modeVal = this.widthVal();
        this.secondaryVal(modeVal);
        if (TelegramNotifier.primaryVal() && TelegramCommand.a_.field_1705 != null && TelegramCommand.a_.field_1705.method_1743() != null) {
            ChatLogger.primaryVal("§aTelegram API loaded successfully.");
        }
    }

    @Compile
    private WildClient widthVal() {
        if (!this.secondaryVal.exists()) {
            return new WildClient();
        }
        try (BufferedReader bufferedReader = Files.newBufferedReader(this.secondaryVal.toPath(), StandardCharsets.UTF_8)) {
            WildClient nodeC = (WildClient)this.primaryVal.fromJson((Reader)bufferedReader, WildClient.class);
            return nodeC != null ? nodeC : new WildClient();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new WildClient();
        }
    }

    @Compile
    private void primaryVal(WildClient modeVal) throws Exception {
        if (!this.secondaryVal.getParentFile().exists()) {
            this.secondaryVal.getParentFile().mkdirs();
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(this.secondaryVal.toPath(), StandardCharsets.UTF_8, new OpenOption[0]);){
            this.primaryVal.toJson((Object)modeVal, (Appendable)bufferedWriter);
        }
    }

    private void secondaryVal(WildClient modeVal) {
        try {
            String string = "";
            String string2 = "";
            if (modeVal.primaryVal != null && !modeVal.primaryVal.isEmpty()) {
                string = AesCipherUtil.secondaryVal(modeVal.primaryVal, "gUhDvBzdE4xq5f4BxkPvxv70VY44WsuH1O6s2nZ2F9U1w9y1VVG1mXQcUfbJM2DDUCd8NvtM0L4O1t1nn8FwwAVYlChNncdagiv9UR8FpLXXF8iMAtlWY4mEnYtLHPB3");
            }
            if (modeVal.secondaryVal != null && !modeVal.secondaryVal.isEmpty()) {
                string2 = AesCipherUtil.secondaryVal(modeVal.secondaryVal, "gUhDvBzdE4xq5f4BxkPvxv70VY44WsuH1O6s2nZ2F9U1w9y1VVG1mXQcUfbJM2DDUCd8NvtM0L4O1t1nn8FwwAVYlChNncdagiv9UR8FpLXXF8iMAtlWY4mEnYtLHPB3");
            }
            TelegramNotifier.primaryVal(string, string2);
        }
        catch (Exception exception) {
            ChatLogger.primaryVal("§cData decryption error.");
            exception.printStackTrace();
        }
    }

    static {
        Loader.initialize();
    }

    static class WildClient {
        String primaryVal;
        String secondaryVal;

        WildClient() {
        }
    }
}

