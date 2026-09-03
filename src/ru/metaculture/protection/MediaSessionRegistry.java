/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class MediaSessionRegistry {
    private final List<MediaSession> primaryVal = new ArrayList<MediaSession>();
    private final List<MediaSession> secondaryVal = Collections.unmodifiableList(this.primaryVal);

    public List<MediaSession> primaryVal() {
        return this.secondaryVal;
    }

    public int secondaryVal() {
        return this.primaryVal.size();
    }

    public MediaSession primaryVal(UUID uUID) {
        for (int i = 0; i < this.primaryVal.size(); ++i) {
            MediaSession modeVal = this.primaryVal.get(i);
            if (!modeVal.id().equals(uUID)) continue;
            return modeVal;
        }
        return null;
    }

    public long primaryVal(MediaSession modeVal, long l) {
        if (!modeVal.playing()) {
            return modeVal.positionMs();
        }
        return modeVal.positionMs() + Math.max(0L, l - modeVal.stampMs());
    }

    void primaryVal(List<MediaSession> list) {
        this.primaryVal.clear();
        this.primaryVal.addAll(list);
    }

    void tertiaryVal() {
        this.primaryVal.clear();
    }

    public record MediaSession(UUID id, UUID owner, String source, double x, double y, double z, float yaw, float width, float height, boolean playing, long positionMs, long stampMs, float volume) {
    }
}

