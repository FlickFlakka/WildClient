/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Callback
 */
package ru.metaculture.protection;

import com.sun.jna.Callback;
import org.wild.rpc.DiscordUser;

public interface DiscordJoinRequestCallback
extends Callback {
    public void primaryVal(DiscordUser var1);
}

