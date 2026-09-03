/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Library
 *  com.sun.jna.Native
 */
package ru.metaculture.protection;

import com.sun.jna.Library;
import com.sun.jna.Native;
import org.wild.rpc.DiscordEventHandlers;
import org.wild.rpc.DiscordRichPresence;

public interface DiscordNativeLibrary
extends Library {
    public void Discord_UpdateHandlers(DiscordEventHandlers var1);

    public void Discord_UpdatePresence(DiscordRichPresence var1);

    public void Discord_Respond(String var1, int var2);

    public void Discord_Register(String var1, String var2);

    public void Discord_Shutdown();

    public void Discord_UpdateConnection();

    public void Discord_RegisterSteamGame(String var1, String var2);

    public void Discord_RunCallbacks();

    public void Discord_Initialize(String var1, DiscordEventHandlers var2, boolean var3, String var4);

    public void Discord_ClearPresence();

    public static class Instance {
        private static DiscordNativeLibrary primaryVal;
        private static boolean secondaryVal;

        public static DiscordNativeLibrary primaryVal() {
            if (!secondaryVal) {
                secondaryVal = true;
                try {
                    primaryVal = (DiscordNativeLibrary)Native.loadLibrary((String)"discord-rpc", DiscordNativeLibrary.class);
                }
                catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                    primaryVal = null;
                }
            }
            return primaryVal;
        }

        public static boolean secondaryVal() {
            return Instance.primaryVal() != null;
        }

        static {
            secondaryVal = false;
        }
    }
}

