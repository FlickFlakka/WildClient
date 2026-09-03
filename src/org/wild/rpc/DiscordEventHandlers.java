/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Structure
 */
package org.wild.rpc;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import ru.metaculture.protection.DiscordErrorCallback;
import ru.metaculture.protection.DiscordJoinGameCallback;
import ru.metaculture.protection.UnVvunvVNVuu;
import ru.metaculture.protection.DiscordDisconnectCallback;
import ru.metaculture.protection.DiscordJoinRequestCallback;
import ru.metaculture.protection.DiscordSpectateGameCallback;

public class DiscordEventHandlers
extends Structure {
    public DiscordDisconnectCallback disconnected;
    public DiscordJoinRequestCallback joinRequest;
    public DiscordSpectateGameCallback spectateGame;
    public UnVvunvVNVuu ready;
    public DiscordErrorCallback errored;
    public DiscordJoinGameCallback joinGame;

    protected List<String> getFieldOrder() {
        String[] stringArray = new String[6];
        stringArray[0] = "ready";
        stringArray[1] = "disconnected";
        stringArray[2] = "errored";
        stringArray[3] = "joinGame";
        stringArray[4] = "spectateGame";
        stringArray[5] = "joinRequest";
        return Arrays.asList(stringArray);
    }
}

