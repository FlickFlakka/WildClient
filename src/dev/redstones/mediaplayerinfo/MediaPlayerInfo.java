/*
 * Decompiled with CFR 0.152.
 */
package dev.redstones.mediaplayerinfo;

import dev.redstones.mediaplayerinfo.IMediaSession;
import dev.redstones.mediaplayerinfo.impl.DummyMediaPlayerInfo;
import dev.redstones.mediaplayerinfo.impl.win.WindowsMediaPlayerInfo;
import java.util.List;
import java.util.Locale;

public interface MediaPlayerInfo {
    public static final MediaPlayerInfo INSTANCE = SystemMediaPlayerInfo.getInstance();

    public List<IMediaSession> getMediaSessions();

    public static final class SystemMediaPlayerInfo {
        private static final MediaPlayerInfo INSTANCE = SystemMediaPlayerInfo.create();

        private static MediaPlayerInfo create() {
            String string = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
            if (string.startsWith("windows") && WindowsMediaPlayerInfo.isAvailable()) {
                return new WindowsMediaPlayerInfo();
            }
            return new DummyMediaPlayerInfo();
        }

        public static MediaPlayerInfo getInstance() {
            return INSTANCE;
        }
    }
}

