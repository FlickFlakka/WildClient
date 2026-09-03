/*
 * Decompiled with CFR 0.152.
 */
package dev.redstones.mediaplayerinfo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.imageio.ImageIO;

public final class MediaInfo
implements Serializable {
    private final String title;
    private final String artist;
    private final byte[] artworkPng;
    private final long position;
    private final long duration;
    private final boolean playing;

    public MediaInfo(String string, String string2, byte[] byArray, long l, long l2, boolean bl) {
        this.title = string == null ? "" : string;
        this.artist = string2 == null ? "" : string2;
        this.artworkPng = byArray == null ? new byte[]{} : Arrays.copyOf(byArray, byArray.length);
        this.position = Math.max(0L, l);
        this.duration = Math.max(0L, l2);
        this.playing = bl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public byte[] getArtworkPng() {
        return Arrays.copyOf(this.artworkPng, this.artworkPng.length);
    }

    public long getPosition() {
        return this.position;
    }

    public long getDuration() {
        return this.duration;
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public boolean getPlaying() {
        return this.playing;
    }

    public BufferedImage getArtwork() {
        if (this.artworkPng.length == 0) {
            return null;
        }
        try {
            return ImageIO.read(new ByteArrayInputStream(this.artworkPng));
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MediaInfo)) return false;
        MediaInfo mediaInfo = (MediaInfo)object;
        if (this.position != mediaInfo.position) return false;
        if (this.duration != mediaInfo.duration) return false;
        if (this.playing != mediaInfo.playing) return false;
        if (!Objects.equals(this.title, mediaInfo.title)) return false;
        if (!Objects.equals(this.artist, mediaInfo.artist)) return false;
        if (!Arrays.equals(this.artworkPng, mediaInfo.artworkPng)) return false;
        return true;
    }

    public int hashCode() {
        Object[] objectArray = new Object[5];
        objectArray[0] = this.title;
        objectArray[1] = this.artist;
        objectArray[2] = this.position;
        objectArray[3] = this.duration;
        objectArray[4] = this.playing;
        int n = Objects.hash(objectArray);
        n = 31 * n + Arrays.hashCode(this.artworkPng);
        return n;
    }

    public String toString() {
        return "MediaInfo{title='" + this.title + "', artist='" + this.artist + "', position=" + this.position + ", duration=" + this.duration + ", playing=" + this.playing + "}";
    }
}

