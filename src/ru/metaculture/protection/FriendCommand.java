/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.reflect.TypeToken
 *  net.minecraft.class_2558
 *  net.minecraft.class_2558$class_10610
 *  net.minecraft.class_2561
 *  net.minecraft.class_2568
 *  net.minecraft.class_2568$class_10613
 *  net.minecraft.class_310
 *  net.minecraft.class_5250
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_2558;
import net.minecraft.class_2561;
import net.minecraft.class_2568;
import net.minecraft.class_310;
import net.minecraft.class_5250;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.SoundUtil;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class FriendCommand
extends ChatCommand {
    private static final Gson primaryVal;
    private static final File secondaryVal;
    private static final Map<String, WildClient> tertiaryVal;
    private static final SimpleDateFormat marginVal;

    public FriendCommand() {
        super("friend", "Friends management", ".friend <add/remove/list/clear> <name>");
        this.primaryVal("add", () -> a_.method_1562().method_2880().stream().map(class_6402 -> class_6402.method_2966().getName()).toList());
        this.primaryVal("remove", () -> new ArrayList<String>(tertiaryVal.keySet()));
        this.primaryVal("list", List::of);
        this.primaryVal("clear", List::of);
        this.extraVal();
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        if (stringArray.length == 0) {
            ChatLogger.primaryVal("§cUsage: " + this.tertiaryVal());
            return;
        }
        switch (stringArray[0].toLowerCase()) {
            case "add": {
                this.tertiaryVal(stringArray);
                break;
            }
            case "remove": {
                this.marginVal(stringArray);
                break;
            }
            case "list": {
                this.paramVal();
                break;
            }
            case "clear": {
                this.weightVal();
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
            ChatLogger.primaryVal("§cSpecify a player's nickname.");
            return;
        }
        FriendCommand.secondaryVal(stringArray[1]);
    }

    @Compile
    private void marginVal(String[] stringArray) {
        if (stringArray.length < 2) {
            ChatLogger.primaryVal("§cSpecify a player's nickname.");
            return;
        }
        String string = stringArray[1].toLowerCase();
        WildClient modeVal = tertiaryVal.remove(string);
        if (modeVal == null) {
            ChatLogger.primaryVal("§ePlayer not found in the friends list.");
            return;
        }
        this.limitVal();
        SoundUtil.primaryVal("friendremove", 100.0f, false);
        ChatLogger.primaryVal("§cRemoved from friends: §f" + string);
    }

    @Compile
    private void weightVal() {
        tertiaryVal.clear();
        this.limitVal();
        ChatLogger.primaryVal("§cFriends list cleared.");
    }

    @Compile
    private void paramVal() {
        if (tertiaryVal.isEmpty()) {
            ChatLogger.primaryVal("§7Friends list is empty.");
            return;
        }
        String string = ru.metaculture.protection.WildClient.primaryVal.paramRef();
        ChatLogger.primaryVal("§fYour friends (§7" + tertiaryVal.size() + "\u00a7f):");
        tertiaryVal.values().stream().sorted(Comparator.comparing(modeVal -> modeVal.secondaryVal)).forEach(modeVal -> {
            class_5250 class_52502 = class_2561.method_43470((String)(" \u00a77- \u00a7f" + modeVal.primaryVal + " §8[added: " + marginVal.format(modeVal.secondaryVal) + "] "));
            class_5250 class_52503 = class_2561.method_43470((String)"§c[Delete]").method_27694(class_25832 -> class_25832.method_10958((class_2558)new class_2558.class_10610(string + "friend remove " + modeVal.primaryVal)).method_10949((class_2568)new class_2568.class_10613((class_2561)class_2561.method_43470((String)"§cClick to remove friend"))));
            FriendCommand.a_.field_1724.method_7353((class_2561)class_52502.method_10852((class_2561)class_52503), false);
        });
    }

    public static boolean primaryVal(String string) {
        if (string == null) {
            return false;
        }
        return tertiaryVal.containsKey(string.toLowerCase());
    }

    public static List<String> marginVal() {
        return tertiaryVal.values().stream().map(modeVal -> modeVal.primaryVal).toList();
    }

    public static void secondaryVal(String string) {
        String string2 = string.toLowerCase();
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.method_1548() != null) {
            if (string.equalsIgnoreCase(class_3102.method_1548().method_1676())) {
                ChatLogger.primaryVal("§cYou cannot add yourself.");
                return;
            }
        }
        if (tertiaryVal.containsKey(string2)) {
            tertiaryVal.remove(string2);
            FriendCommand.speedVal();
            SoundUtil.primaryVal("friendremove", 100.0f, false);
            ChatLogger.primaryVal("§cRemoved from friends: §f" + string);
        } else {
            WildClient modeVal = new WildClient(string, new Date());
            tertiaryVal.put(string2, modeVal);
            FriendCommand.speedVal();
            SoundUtil.primaryVal("friendadd", 100.0f, false);
            ChatLogger.primaryVal("§aAdded to friends: §f" + string + " \u00a77(" + marginVal.format(modeVal.secondaryVal) + ")");
        }
    }

    @Compile
    private void extraVal() {
        if (!secondaryVal.exists()) {
            return;
        }
        try (FileReader fileReader = new FileReader(secondaryVal);){
            Type type = new TypeToken<Map<String, WildClient>>(){}.getType();
            Map map = (Map)primaryVal.fromJson((Reader)fileReader, type);
            tertiaryVal.clear();
            if (map != null) {
                tertiaryVal.putAll(map);
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    @Compile
    private void limitVal() {
        FriendCommand.speedVal();
    }

    @Compile
    private static void speedVal() {
        try {
            if (!secondaryVal.getParentFile().exists()) {
                secondaryVal.getParentFile().mkdirs();
            }
            try (FileWriter fileWriter = new FileWriter(secondaryVal);){
                primaryVal.toJson(tertiaryVal, (Appendable)fileWriter);
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    static {
        Loader.initialize();
        primaryVal = new GsonBuilder().setPrettyPrinting().create();
        secondaryVal = new File(ru.metaculture.protection.WildClient.primaryVal.paramVal, "friend.cfg");
        tertiaryVal = new HashMap<String, WildClient>();
        marginVal = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    }

    static class WildClient {
        String primaryVal;
        Date secondaryVal;

        WildClient(String string, Date date) {
            this.primaryVal = string;
            this.secondaryVal = date;
        }
    }
}

