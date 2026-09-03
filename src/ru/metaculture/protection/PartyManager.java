/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.minecraft.class_310
 *  net.minecraft.class_320
 */
package ru.metaculture.protection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.UUID;
import net.minecraft.class_310;
import net.minecraft.class_320;
import ru.metaculture.protection.NnNUnv;
import ru.metaculture.protection.PartyEndpoint;
import ru.metaculture.protection.MediaSessionRegistry;
import ru.metaculture.protection.PartyState;
import ru.metaculture.protection.PartyNetworkClient;
import ru.metaculture.protection.ConnectionState;
import ru.metaculture.protection.UserProfile;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.PartyProtocolMessages;

public final class PartyManager {
    private static final PartyManager primaryVal = new PartyManager();
    private final PartyNetworkClient secondaryVal = new PartyNetworkClient();
    private final PartyState tertiaryVal = new PartyState();
    private final MediaSessionRegistry marginVal = new MediaSessionRegistry();
    private final NnNUnv weightVal = new NnNUnv();
    private UUID paramVal;

    private PartyManager() {
    }

    public static PartyManager primaryVal() {
        return primaryVal;
    }

    public PartyState secondaryVal() {
        return this.tertiaryVal;
    }

    public MediaSessionRegistry tertiaryVal() {
        return this.marginVal;
    }

    public NnNUnv marginVal() {
        return this.weightVal;
    }

    public ConnectionState weightVal() {
        return this.secondaryVal.tertiaryVal();
    }

    public boolean paramVal() {
        return this.secondaryVal.marginVal();
    }

    public String extraVal() {
        return this.secondaryVal.weightVal();
    }

    public UUID limitVal() {
        return this.paramVal;
    }

    public void speedVal() {
        this.primaryVal(PartyEndpoint.primaryVal());
    }

    public void primaryVal(PartyEndpoint silkD) {
        this.anchorVal();
        this.secondaryVal.primaryVal(silkD, this.weightRef());
    }

    public void widthVal() {
        this.secondaryVal.primaryVal();
        this.anchorVal();
    }

    public boolean primaryVal(String string) {
        return this.secondaryVal.primaryVal(PartyProtocolMessages.primaryVal(string));
    }

    public boolean secondaryVal(String string) {
        return this.secondaryVal.primaryVal(PartyProtocolMessages.secondaryVal(string));
    }

    public boolean chunkVal() {
        return this.secondaryVal.primaryVal(PartyProtocolMessages.primaryVal());
    }

    public boolean primaryVal(UUID uUID) {
        return this.secondaryVal.primaryVal(PartyProtocolMessages.primaryVal(uUID));
    }

    public boolean primaryVal(double d, double d2, double d3, float f, float f2, float f3) {
        return this.secondaryVal.primaryVal(PartyProtocolMessages.primaryVal(d, d2, d3, f, f2, f3));
    }

    public boolean primaryVal(UUID uUID, double d, double d2, double d3, float f, float f2, float f3) {
        return this.secondaryVal.primaryVal(PartyProtocolMessages.primaryVal(uUID, d, d2, d3, f, f2, f3));
    }

    public boolean secondaryVal(UUID uUID) {
        return this.secondaryVal.primaryVal(PartyProtocolMessages.secondaryVal(uUID));
    }

    public boolean primaryVal(UUID uUID, String string, boolean bl, long l, float f) {
        return this.secondaryVal.primaryVal(PartyProtocolMessages.primaryVal(uUID, string, bl, l, f));
    }

    public void blockRef() {
        this.timerVal();
        for (int i = 0; i < 64; ++i) {
            String string = this.secondaryVal.secondaryVal();
            if (string == null) {
                return;
            }
            this.tertiaryVal(string);
        }
    }

    private void timerVal() {
        if (!this.secondaryVal.marginVal()) {
            return;
        }
        long l = System.currentTimeMillis();
        if (!this.weightVal.primaryVal(l)) {
            return;
        }
        if (this.secondaryVal.primaryVal(PartyProtocolMessages.primaryVal(l))) {
            this.weightVal.secondaryVal(l);
        }
    }

    private void tertiaryVal(String string) {
        JsonObject jsonObject = PartyManager.weightVal(string);
        if (jsonObject == null) {
            return;
        }
        switch (PartyManager.secondaryVal(jsonObject, "type")) {
            case "welcome": {
                this.primaryVal(jsonObject);
                break;
            }
            case "party_state": {
                this.secondaryVal(jsonObject);
                break;
            }
            case "party_closed": {
                this.tertiaryVal(jsonObject);
                break;
            }
            case "screens_state": {
                this.marginVal(jsonObject);
                break;
            }
            case "time_echo": {
                this.weightVal(jsonObject);
                break;
            }
            case "error": {
                this.paramVal(jsonObject);
                break;
            }
        }
    }

    private void primaryVal(JsonObject jsonObject) {
        this.paramVal = PartyManager.paramVal(jsonObject, "uuid");
        ChatLogger.primaryVal("Connected to the Wild server");
    }

    private void secondaryVal(JsonObject jsonObject) {
        ArrayList<PartyState.Member> arrayList = new ArrayList<PartyState.Member>();
        for (JsonElement jsonElement : PartyManager.primaryVal(jsonObject, "members")) {
            JsonObject jsonObject2;
            UUID uUID;
            if (!jsonElement.isJsonObject() || (uUID = PartyManager.paramVal(jsonObject2 = jsonElement.getAsJsonObject(), "uuid")) == null) continue;
            arrayList.add(new PartyState.Member(uUID, PartyManager.secondaryVal(jsonObject2, "username")));
        }
        this.tertiaryVal.primaryVal(PartyManager.paramVal(jsonObject, "party_id"), PartyManager.paramVal(jsonObject, "leader"), PartyManager.secondaryVal(jsonObject, "code"), arrayList);
    }

    private void tertiaryVal(JsonObject jsonObject) {
        this.tertiaryVal.paramVal();
        this.marginVal.tertiaryVal();
        ChatLogger.primaryVal(PartyManager.secondaryVal(jsonObject, "reason").equals("kicked") ? "You were removed from the room" : "You left the room");
    }

    private void marginVal(JsonObject jsonObject) {
        ArrayList<MediaSessionRegistry.MediaSession> arrayList = new ArrayList<MediaSessionRegistry.MediaSession>();
        for (JsonElement jsonElement : PartyManager.primaryVal(jsonObject, "screens")) {
            if (!jsonElement.isJsonObject()) {
                continue;
            }
            JsonObject jsonObject2 = jsonElement.getAsJsonObject();
            UUID uUID = PartyManager.paramVal(jsonObject2, "id");
            if (uUID == null) continue;
            arrayList.add(new MediaSessionRegistry.MediaSession(uUID, PartyManager.paramVal(jsonObject2, "owner"), PartyManager.secondaryVal(jsonObject2, "source"), PartyManager.tertiaryVal(jsonObject2, "x"), PartyManager.tertiaryVal(jsonObject2, "y"), PartyManager.tertiaryVal(jsonObject2, "z"), (float)PartyManager.tertiaryVal(jsonObject2, "yaw"), (float)PartyManager.tertiaryVal(jsonObject2, "width"), (float)PartyManager.tertiaryVal(jsonObject2, "height"), PartyManager.weightVal(jsonObject2, "playing"), PartyManager.marginVal(jsonObject2, "position_ms"), PartyManager.marginVal(jsonObject2, "stamp_ms"), (float)PartyManager.tertiaryVal(jsonObject2, "volume")));
        }
        this.marginVal.primaryVal(arrayList);
    }

    private void weightVal(JsonObject jsonObject) {
        this.weightVal.primaryVal(PartyManager.marginVal(jsonObject, "c"), PartyManager.marginVal(jsonObject, "s"), System.currentTimeMillis());
    }

    private void paramVal(JsonObject jsonObject) {
        ChatLogger.primaryVal(PartyManager.marginVal(PartyManager.secondaryVal(jsonObject, "code")));
    }

    private static String marginVal(String string) {
        return switch (string) {
            case "code_taken" -> "This code is already taken";
            case "unknown_code" -> "No room found with that code";
            case "already_in_party" -> "You are already in a room";
            case "not_in_party" -> "You are not in a room";
            case "not_leader" -> "Only the room owner can do this";
            case "unknown_member" -> "No such member in the room";
            case "rate_limited" -> "Too many attempts, please wait";
            case "invalid_code" -> "Invalid code format";
            case "screen_limit" -> "Room already has the maximum number of screens";
            case "unknown_screen" -> "No such screen in the room";
            case "not_screen_owner" -> "The screen is controlled by its owner or the room owner";
            case "invalid_screen" -> "The screen cannot be placed here";
            case "cannot_transfer_to_self" -> "You are already controlling the room";
            default -> "Server error";
        };
    }

    public String holderVal() {
        class_320 class_3202;
        class_310 class_3102 = class_310.method_1551();
        class_320 class_3203 = class_3202 = class_3102 == null ? null : class_3102.method_1548();
        return class_3202 == null ? "" : class_3202.method_1676();
    }

    private void anchorVal() {
        this.paramVal = null;
        this.tertiaryVal.paramVal();
        this.marginVal.tertiaryVal();
        this.weightVal.marginVal();
    }

    private UserProfile weightRef() {
        class_310 class_3102 = class_310.method_1551();
        class_320 class_3202 = class_3102 == null ? null : class_3102.method_1548();
        UUID uUID = class_3202 == null ? null : class_3202.method_44717();
        String string = this.holderVal();
        if (uUID == null) {
            uUID = UUID.nameUUIDFromBytes(("WildOffline:" + string).getBytes());
        }
        return UserProfile.of(uUID, string, null);
    }

    private static JsonObject weightVal(String string) {
        try {
            JsonElement jsonElement = JsonParser.parseString((String)string);
            return jsonElement.isJsonObject() ? jsonElement.getAsJsonObject() : null;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static JsonArray primaryVal(JsonObject jsonObject, String string) {
        JsonArray jsonArray;
        JsonElement jsonElement = jsonObject.get(string);
        if (jsonElement != null) {
            if (jsonElement.isJsonArray()) {
                jsonArray = jsonElement.getAsJsonArray();
                return jsonArray;
            }
        }
        jsonArray = new JsonArray();
        return jsonArray;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String secondaryVal(JsonObject jsonObject, String string) {
        JsonElement jsonElement = jsonObject.get(string);
        if (jsonElement == null) return "";
        if (!jsonElement.isJsonPrimitive()) {
            return "";
        }
        String string2 = jsonElement.getAsString();
        return string2;
    }

    private static double tertiaryVal(JsonObject jsonObject, String string) {
        JsonElement jsonElement = jsonObject.get(string);
        try {
            return jsonElement == null || !jsonElement.isJsonPrimitive() ? 0.0 : jsonElement.getAsDouble();
        }
        catch (NumberFormatException numberFormatException) {
            return 0.0;
        }
    }

    private static long marginVal(JsonObject jsonObject, String string) {
        JsonElement jsonElement = jsonObject.get(string);
        try {
            return jsonElement == null || !jsonElement.isJsonPrimitive() ? 0L : jsonElement.getAsLong();
        }
        catch (NumberFormatException numberFormatException) {
            return 0L;
        }
    }

    private static boolean weightVal(JsonObject jsonObject, String string) {
        JsonElement jsonElement = jsonObject.get(string);
        return jsonElement != null && jsonElement.isJsonPrimitive() && jsonElement.getAsBoolean();
    }

    private static UUID paramVal(JsonObject jsonObject, String string) {
        String string2 = PartyManager.secondaryVal(jsonObject, string);
        if (string2.isEmpty()) {
            return null;
        }
        try {
            return UUID.fromString(string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }
}

