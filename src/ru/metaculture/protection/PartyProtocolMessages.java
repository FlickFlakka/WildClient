/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 */
package ru.metaculture.protection;

import com.google.gson.JsonObject;
import java.util.UUID;
import ru.metaculture.protection.UserProfile;

public final class PartyProtocolMessages {
    public static final int primaryVal = 1;
    static final String secondaryVal = "welcome";
    static final String tertiaryVal = "party_state";
    static final String marginVal = "party_closed";
    static final String weightVal = "screens_state";
    static final String paramVal = "time_echo";
    static final String extraVal = "error";

    private PartyProtocolMessages() {
    }

    static String primaryVal(UserProfile unuUNUU2) {
        JsonObject jsonObject = PartyProtocolMessages.tertiaryVal("hello");
        jsonObject.addProperty("v", (Number)1);
        jsonObject.addProperty("username", unuUNUU2.username());
        jsonObject.addProperty("uuid", unuUNUU2.uuid().toString());
        if (unuUNUU2.avatarUrl() != null) {
            jsonObject.addProperty("avatar", unuUNUU2.avatarUrl());
        }
        return jsonObject.toString();
    }

    static String primaryVal(String string) {
        return PartyProtocolMessages.primaryVal("party_create", string);
    }

    static String secondaryVal(String string) {
        return PartyProtocolMessages.primaryVal("party_join", string);
    }

    static String primaryVal() {
        return PartyProtocolMessages.tertiaryVal("party_leave").toString();
    }

    static String primaryVal(UUID uUID) {
        JsonObject jsonObject = PartyProtocolMessages.tertiaryVal("party_transfer");
        jsonObject.addProperty("target", uUID.toString());
        return jsonObject.toString();
    }

    static String primaryVal(double d, double d2, double d3, float f, float f2, float f3) {
        return PartyProtocolMessages.primaryVal(PartyProtocolMessages.tertiaryVal("screen_create"), d, d2, d3, f, f2, f3);
    }

    static String primaryVal(UUID uUID, double d, double d2, double d3, float f, float f2, float f3) {
        JsonObject jsonObject = PartyProtocolMessages.tertiaryVal("screen_move");
        jsonObject.addProperty("id", uUID.toString());
        return PartyProtocolMessages.primaryVal(jsonObject, d, d2, d3, f, f2, f3);
    }

    static String secondaryVal(UUID uUID) {
        JsonObject jsonObject = PartyProtocolMessages.tertiaryVal("screen_remove");
        jsonObject.addProperty("id", uUID.toString());
        return jsonObject.toString();
    }

    static String primaryVal(UUID uUID, String string, boolean bl, long l, float f) {
        JsonObject jsonObject = PartyProtocolMessages.tertiaryVal("screen_playback");
        jsonObject.addProperty("id", uUID.toString());
        jsonObject.addProperty("source", string);
        jsonObject.addProperty("playing", Boolean.valueOf(bl));
        jsonObject.addProperty("position_ms", (Number)l);
        jsonObject.addProperty("volume", (Number)Float.valueOf(f));
        return jsonObject.toString();
    }

    static String primaryVal(long l) {
        JsonObject jsonObject = PartyProtocolMessages.tertiaryVal("time_sync");
        jsonObject.addProperty("c", (Number)l);
        return jsonObject.toString();
    }

    private static String primaryVal(JsonObject jsonObject, double d, double d2, double d3, float f, float f2, float f3) {
        jsonObject.addProperty("x", (Number)d);
        jsonObject.addProperty("y", (Number)d2);
        jsonObject.addProperty("z", (Number)d3);
        jsonObject.addProperty("yaw", (Number)Float.valueOf(f));
        jsonObject.addProperty("width", (Number)Float.valueOf(f2));
        jsonObject.addProperty("height", (Number)Float.valueOf(f3));
        return jsonObject.toString();
    }

    private static String primaryVal(String string, String string2) {
        JsonObject jsonObject = PartyProtocolMessages.tertiaryVal(string);
        jsonObject.addProperty("code", string2);
        return jsonObject.toString();
    }

    private static JsonObject tertiaryVal(String string) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", string);
        return jsonObject;
    }
}

