/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.List;
import java.util.UUID;
import ru.metaculture.protection.VvUUVVVNNUN;
import ru.metaculture.protection.MediaSessionRegistry;
import ru.metaculture.protection.PanelRayHitTester;

public final class MediaPanelInteractionController {
    private final PanelRayHitTester primaryVal = new PanelRayHitTester();
    private UUID secondaryVal;
    private UUID tertiaryVal;
    private VvUUVVVNNUN marginVal = VvUUVVVNNUN.NONE;
    private UUID weightVal;
    private VvUUVVVNNUN paramVal = VvUUVVVNNUN.NONE;
    private double extraVal;
    private double limitVal;
    private double speedVal;
    private double widthVal;
    private double chunkVal;
    private double blockRef;
    private double holderVal;
    private float timerVal;
    private float anchorVal;
    private float weightRef;
    private long bufferVal;

    public UUID primaryVal() {
        return this.secondaryVal;
    }

    public UUID secondaryVal() {
        return this.tertiaryVal;
    }

    public VvUUVVVNNUN tertiaryVal() {
        return this.marginVal;
    }

    public boolean marginVal() {
        return this.weightVal != null;
    }

    public UUID weightVal() {
        return this.weightVal;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(UUID uUID) {
        if (this.weightVal == null) return false;
        if (!this.weightVal.equals(uUID)) return false;
        return true;
    }

    public double paramVal() {
        return this.chunkVal;
    }

    public double extraVal() {
        return this.blockRef;
    }

    public double limitVal() {
        return this.holderVal;
    }

    public float speedVal() {
        return this.timerVal;
    }

    public float widthVal() {
        return this.anchorVal;
    }

    public float chunkVal() {
        return this.weightRef;
    }

    public void primaryVal(List<MediaSessionRegistry.MediaSession> list, UUID uUID, boolean bl, double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.weightVal != null) {
            return;
        }
        this.secondaryVal = null;
        this.tertiaryVal = null;
        this.marginVal = VvUUVVVNNUN.NONE;
        double d7 = Double.MAX_VALUE;
        double d8 = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); ++i) {
            MediaSessionRegistry.MediaSession modeVal = list.get(i);
            if (!MediaPanelInteractionController.primaryVal(modeVal, uUID, bl)) continue;
            this.primaryVal.primaryVal(modeVal);
            if (!this.primaryVal.primaryVal(d, d2, d3, d4, d5, d6)) continue;
            VvUUVVVNNUN vvUUVVVNNUN = MediaPanelInteractionController.primaryVal(this.primaryVal);
            if (vvUUVVVNNUN != VvUUVVVNNUN.NONE) {
                if (this.primaryVal.limitVal() < d7) {
                    d7 = this.primaryVal.limitVal();
                    this.secondaryVal = modeVal.id();
                    this.marginVal = vvUUVVVNNUN;
                }
            }
            if (vvUUVVVNNUN == VvUUVVVNNUN.NONE && !this.primaryVal.sourceVal() || !(this.primaryVal.limitVal() < d8)) continue;
            d8 = this.primaryVal.limitVal();
            this.tertiaryVal = modeVal.id();
        }
    }

    public boolean primaryVal(MediaSessionRegistry.MediaSession modeVal, double d, double d2, double d3, double d4, double d5, double d6) {
        if (modeVal == null || this.marginVal == VvUUVVVNNUN.NONE) {
            return false;
        }
        this.primaryVal.primaryVal(modeVal);
        if (!this.primaryVal.primaryVal(d, d2, d3, d4, d5, d6)) {
            return false;
        }
        this.weightVal = modeVal.id();
        this.paramVal = this.marginVal;
        this.extraVal = this.primaryVal.limitVal();
        this.limitVal = modeVal.x() - (d + d4 * this.extraVal);
        this.speedVal = modeVal.y() - (d2 + d5 * this.extraVal);
        this.widthVal = modeVal.z() - (d3 + d6 * this.extraVal);
        this.chunkVal = modeVal.x();
        this.blockRef = modeVal.y();
        this.holderVal = modeVal.z();
        this.timerVal = modeVal.yaw();
        this.anchorVal = modeVal.width();
        this.weightRef = modeVal.height();
        this.bufferVal = 0L;
        return true;
    }

    public double blockRef() {
        return this.extraVal;
    }

    public void primaryVal(double d) {
        if (this.paramVal == VvUUVVVNNUN.MOVE) {
            if (d < this.extraVal) {
                this.extraVal = d;
            }
        }
    }

    public void primaryVal(double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.weightVal == null) {
            return;
        }
        if (this.paramVal == VvUUVVVNNUN.MOVE) {
            this.chunkVal = d + d4 * this.extraVal + this.limitVal;
            this.blockRef = d2 + d5 * this.extraVal + this.speedVal;
            this.holderVal = d3 + d6 * this.extraVal + this.widthVal;
            return;
        }
        this.primaryVal.primaryVal(this.chunkVal, this.blockRef, this.holderVal, this.timerVal, this.anchorVal, this.weightRef);
        if (!this.primaryVal.primaryVal(d, d2, d3, d4, d5, d6)) {
            return;
        }
        double d7 = Math.abs(this.primaryVal.paramVal());
        double d8 = Math.abs(this.primaryVal.extraVal()) * 1.7777777777777777;
        double d9 = Math.clamp(Math.max(d7, d8), 0.45, 24.0);
        this.anchorVal = (float)(d9 * 2.0);
        this.weightRef = this.anchorVal * 9.0f / 16.0f;
    }

    public boolean primaryVal(long l) {
        if (this.weightVal == null || l - this.bufferVal < 100L) {
            return false;
        }
        this.bufferVal = l;
        return true;
    }

    public UUID holderVal() {
        UUID uUID = this.weightVal;
        this.weightVal = null;
        this.paramVal = VvUUVVVNNUN.NONE;
        return uUID;
    }

    public void timerVal() {
        this.secondaryVal = null;
        this.tertiaryVal = null;
        this.marginVal = VvUUVVVNNUN.NONE;
        this.weightVal = null;
        this.paramVal = VvUUVVVNNUN.NONE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(MediaSessionRegistry.MediaSession modeVal, UUID uUID, boolean bl) {
        if (uUID == null) return false;
        if (bl) return true;
        if (!uUID.equals(modeVal.owner())) return false;
        return true;
    }

    private static VvUUVVVNNUN primaryVal(PanelRayHitTester nnunnunvvuv2) {
        if (nnunnunvvuv2.phaseVal()) {
            return VvUUVVVNNUN.RESIZE;
        }
        if (nnunnunvvuv2.extraRef()) {
            return VvUUVVVNNUN.MOVE;
        }
        return VvUUVVVNNUN.NONE;
    }
}

