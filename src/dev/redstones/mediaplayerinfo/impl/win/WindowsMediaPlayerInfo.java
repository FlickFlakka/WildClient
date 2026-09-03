/*
 * Decompiled with CFR 0.152.
 */
package dev.redstones.mediaplayerinfo.impl.win;

import dev.redstones.mediaplayerinfo.IMediaSession;
import dev.redstones.mediaplayerinfo.MediaPlayerInfo;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class WindowsMediaPlayerInfo
implements MediaPlayerInfo {
    private static final String RESOURCE_PATH = "/mediaplayerinfo/natives/win/MediaPlayerInfo.dll";
    private static final boolean LOADED;
    private static final Throwable LOAD_ERROR;
    private static final AtomicBoolean LOAD_ERROR_LOGGED;

    public WindowsMediaPlayerInfo() {
        if (!LOADED) {
            WindowsMediaPlayerInfo.logLoadError();
        }
    }

    public static boolean isAvailable() {
        if (!LOADED) {
            WindowsMediaPlayerInfo.logLoadError();
        }
        return LOADED;
    }

    @Override
    public native List<IMediaSession> getMediaSessions();

    private static void logLoadError() {
        if (LOAD_ERROR_LOGGED.compareAndSet(false, true)) {
            System.err.println("[Wild][MusicPlayer] MediaPlayerInfo native load failed: " + WindowsMediaPlayerInfo.errorSummary(LOAD_ERROR));
        }
    }

    private static String errorSummary(Throwable throwable) {
        if (throwable == null) {
            return "unknown";
        }
        String string = throwable.getMessage();
        return throwable.getClass().getSimpleName() + (String)(string == null || string.isBlank() ? "" : ": " + string);
    }

    private static LoadResult loadNative() {
        try {
            Path path = Files.createTempDirectory("mediaplayerinfo-", new FileAttribute[0]);
            Path path2 = path.resolve("MediaPlayerInfo.dll");
            try (InputStream inputStream = WindowsMediaPlayerInfo.class.getResourceAsStream(RESOURCE_PATH);){
                if (inputStream == null) {
                    throw new IOException("Resource not found: /mediaplayerinfo/natives/win/MediaPlayerInfo.dll");
                }
                CopyOption[] copyOptionArray = new CopyOption[1];
                copyOptionArray[0] = StandardCopyOption.REPLACE_EXISTING;
                Files.copy(inputStream, path2, copyOptionArray);
            }
            System.load(path2.toAbsolutePath().toString());
            try {
                Files.deleteIfExists(path2);
                Files.deleteIfExists(path);
            }
            catch (IOException iOException) {
                path2.toFile().deleteOnExit();
                path.toFile().deleteOnExit();
            }
            return new LoadResult(true, null);
        }
        catch (Throwable throwable) {
            return new LoadResult(false, throwable);
        }
    }

    static {
        LOAD_ERROR_LOGGED = new AtomicBoolean(false);
        LoadResult loadResult = WindowsMediaPlayerInfo.loadNative();
        LOADED = loadResult.loaded();
        LOAD_ERROR = loadResult.error();
    }

    record LoadResult(boolean loaded, Throwable error) {
    }
}

