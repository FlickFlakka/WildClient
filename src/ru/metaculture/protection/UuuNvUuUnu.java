/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  net.minecraft.class_310
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;
import net.minecraft.class_310;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.metaculture.protection.PartyWebSocketClient;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class UuuNvUuUnu
extends ChatCommand {
    private static final Pattern marginVal;
    private static final Gson weightVal;
    private static final File paramVal;
    public static volatile String primaryVal;
    public static volatile String secondaryVal;
    public static volatile boolean tertiaryVal;
    private static volatile boolean extraVal;

    public UuuNvUuUnu() {
        super("party", "Group by code (16-character codes, leader creates)", ".party <create|connect <code>|leave|list|kick <nick>>");
        this.primaryVal("create", () -> List.of("creates a group, gives a code"));
        this.primaryVal("connect", () -> List.of("CODE_16_CHARACTERS"));
        this.primaryVal("leave", () -> List.of("leave (leader deletes the whole group)"));
        this.primaryVal("list", () -> List.of("member list"));
        this.primaryVal("kick", () -> PartyWebSocketClient.paramVal() != null ? PartyWebSocketClient.paramVal() : List.of());
        UuuNvUuUnu.widthVal();
        PartyWebSocketClient.tertiaryVal = UuuNvUuUnu::primaryVal;
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        if (stringArray.length == 0) {
            ChatLogger.primaryVal("§cUsage: §f" + this.tertiaryVal());
            return;
        }
        switch (stringArray[0].toLowerCase()) {
            case "create": {
                this.paramVal();
                break;
            }
            case "connect": 
            case "join": {
                this.tertiaryVal(stringArray);
                break;
            }
            case "leave": {
                this.extraVal();
                break;
            }
            case "list": {
                this.limitVal();
                break;
            }
            case "kick": {
                this.marginVal(stringArray);
                break;
            }
            default: {
                ChatLogger.primaryVal("§cUnknown subcommand: §f" + stringArray[0]);
            }
        }
    }

    @Compile
    private void paramVal() {
        PartyWebSocketClient cellB = PartyWebSocketClient.primaryVal;
        if (cellB == null || !cellB.isOpen()) {
            ChatLogger.primaryVal("§c[Party] Marker server not connected. Enable the Party module.");
            return;
        }
        PartyWebSocketClient.primaryVal(cellB, "create", new String[0]);
    }

    @Compile
    private void tertiaryVal(String[] stringArray) {
        if (stringArray.length < 2) {
            ChatLogger.primaryVal("§cSpecify the group code: §f.party connect <code>");
            return;
        }
        String string = stringArray[1].trim().toUpperCase();
        if (!marginVal.matcher(string).matches()) {
            ChatLogger.primaryVal("§cThe code must consist of 16 characters A-Z/0-9.");
            return;
        }
        PartyWebSocketClient cellB = PartyWebSocketClient.primaryVal;
        if (cellB == null || !cellB.isOpen()) {
            ChatLogger.primaryVal("§c[Party] Marker server not connected. Enable the Party module.");
            return;
        }
        PartyWebSocketClient.primaryVal(cellB, "join", string);
    }

    @Compile
    private void extraVal() {
        if (primaryVal.isEmpty()) {
            ChatLogger.primaryVal("§eYou are not in a group.");
            return;
        }
        PartyWebSocketClient cellB = PartyWebSocketClient.primaryVal;
        if (cellB == null || !cellB.isOpen()) {
            ChatLogger.primaryVal("§c[Party] Marker server not connected.");
            return;
        }
        PartyWebSocketClient.primaryVal(cellB, "leave", new String[0]);
    }

    @Compile
    private void limitVal() {
        if (primaryVal.isEmpty()) {
            ChatLogger.primaryVal("§eYou are not in a group.");
            return;
        }
        PartyWebSocketClient cellB = PartyWebSocketClient.primaryVal;
        if (cellB == null || !cellB.isOpen()) {
            ChatLogger.primaryVal("§c[Party] Marker server not connected.");
            return;
        }
        extraVal = true;
        PartyWebSocketClient.primaryVal(cellB, "list", new String[0]);
    }

    @Compile
    private void marginVal(String[] stringArray) {
        if (stringArray.length < 2) {
            ChatLogger.primaryVal("§cSpecify a nickname: §f.party kick <nick>");
            return;
        }
        if (!tertiaryVal) {
            ChatLogger.primaryVal("§cOnly the group creator can kick.");
            return;
        }
        PartyWebSocketClient cellB = PartyWebSocketClient.primaryVal;
        if (cellB == null || !cellB.isOpen()) {
            ChatLogger.primaryVal("§c[Party] Marker server not connected.");
            return;
        }
        String string = "kick";
        String string2 = stringArray[1];
        String[] stringArray2 = new String[1];
        if (string2 != null) {
            stringArray2[0] = string2;
        }
        PartyWebSocketClient.primaryVal(cellB, string, stringArray2);
    }

    private static void primaryVal(JSONObject jSONObject) {
        String string;
        switch (string = jSONObject.optString("op")) {
            case "created": {
                primaryVal = jSONObject.optString("code", "");
                secondaryVal = jSONObject.optString("owner", UuuNvUuUnu.speedVal());
                tertiaryVal = true;
                UuuNvUuUnu.chunkVal();
                ChatLogger.primaryVal("§aGroup created. Group code: §f" + primaryVal);
                ChatLogger.primaryVal("§7Give this code to your friends: §f.party connect " + primaryVal);
                break;
            }
            case "joined": {
                primaryVal = jSONObject.optString("code", "");
                secondaryVal = jSONObject.optString("owner", "");
                tertiaryVal = false;
                UuuNvUuUnu.chunkVal();
                PartyWebSocketClient.secondaryVal.clear();
                ChatLogger.primaryVal("§aYou are in group §f" + secondaryVal + "§a. Code: §f" + primaryVal);
                break;
            }
            case "left": {
                primaryVal = "";
                secondaryVal = "";
                tertiaryVal = false;
                PartyWebSocketClient.weightVal();
                UuuNvUuUnu.chunkVal();
                PartyWebSocketClient.secondaryVal.clear();
                ChatLogger.primaryVal("§eYou left the group.");
                break;
            }
            case "party_closed": {
                primaryVal = "";
                secondaryVal = "";
                tertiaryVal = false;
                PartyWebSocketClient.weightVal();
                UuuNvUuUnu.chunkVal();
                PartyWebSocketClient.secondaryVal.clear();
                ChatLogger.primaryVal("§cGroup closed by the owner.");
                break;
            }
            case "kicked": {
                primaryVal = "";
                secondaryVal = "";
                tertiaryVal = false;
                PartyWebSocketClient.weightVal();
                UuuNvUuUnu.chunkVal();
                PartyWebSocketClient.secondaryVal.clear();
                ChatLogger.primaryVal("§cYou were removed from the group.");
                break;
            }
            case "party_state": {
                secondaryVal = jSONObject.optString("owner", "");
                tertiaryVal = secondaryVal.equalsIgnoreCase(UuuNvUuUnu.speedVal());
                if (!extraVal) break;
                extraVal = false;
                UuuNvUuUnu.primaryVal(jSONObject.optJSONArray("members"));
                break;
            }
            case "error": {
                if (extraVal) {
                    extraVal = false;
                }
                ChatLogger.primaryVal("\u00a7c[Party] " + jSONObject.optString("msg", "error"));
                break;
            }
        }
    }

    private static void primaryVal(JSONArray jSONArray) {
        block4: {
            block3: {
                if (jSONArray == null) break block3;
                if (jSONArray.length() != 0) break block4;
            }
            ChatLogger.primaryVal("§7The group is empty for now.");
            return;
        }
        ChatLogger.primaryVal("§fGroup members §8(" + jSONArray.length() + "\u00a78):");
        for (int i = 0; i < jSONArray.length(); ++i) {
            String string = jSONArray.getString(i);
            String string2 = string.equalsIgnoreCase(secondaryVal) ? " §a[leader]" : "";
            ChatLogger.primaryVal(" \u00a77- \u00a7f" + string + string2);
        }
    }

    private static String speedVal() {
        class_310 class_3102;
        block3: {
            block2: {
                class_3102 = class_310.method_1551();
                if (class_3102 == null) break block2;
                if (class_3102.method_1548() != null) break block3;
            }
            return "";
        }
        return class_3102.method_1548().method_1676();
    }

    public static String marginVal() {
        return primaryVal;
    }

    public static List<String> weightVal() {
        return PartyWebSocketClient.paramVal();
    }

    @Compile
    private static void widthVal() {
        if (!paramVal.exists()) {
            return;
        }
        try (FileReader fileReader = new FileReader(paramVal);){
            WildClient modeVal = (WildClient)weightVal.fromJson((Reader)fileReader, WildClient.class);
            if (modeVal != null) {
                String string = modeVal.primaryVal != null ? modeVal.primaryVal : "";
                Field field = UuuNvUuUnu.class.getDeclaredField("primaryVal");
                field.setAccessible(true);
                field.set(null, string);
                String string2 = modeVal.secondaryVal != null ? modeVal.secondaryVal : "";
                Field field2 = UuuNvUuUnu.class.getDeclaredField("secondaryVal");
                field2.setAccessible(true);
                field2.set(null, string2);
                tertiaryVal = modeVal.secondaryVal != null && modeVal.secondaryVal.equalsIgnoreCase(UuuNvUuUnu.speedVal());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Compile
    private static void chunkVal() {
        try {
            if (!paramVal.getParentFile().exists()) {
                paramVal.getParentFile().mkdirs();
            }
            try (FileWriter fileWriter = new FileWriter(paramVal);){
                WildClient modeVal = new WildClient();
                modeVal.primaryVal = primaryVal;
                modeVal.secondaryVal = secondaryVal;
                weightVal.toJson((Object)modeVal, (Appendable)fileWriter);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static {
        Loader.initialize();
        marginVal = Pattern.compile("^[A-Z0-9]{16}$");
        weightVal = new GsonBuilder().setPrettyPrinting().create();
        paramVal = new File(ru.metaculture.protection.WildClient.primaryVal.paramVal, "party.cfg");
        primaryVal = "";
        secondaryVal = "";
    }

    static class WildClient {
        String primaryVal;
        String secondaryVal;

        WildClient() {
        }
    }
}

