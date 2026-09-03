/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class SpringPresets {
    public static final Preset primaryVal = new Preset(1.9f, 0.94f, 0.02f);
    public static final Preset secondaryVal = new Preset(2.6f, 1.0f, 5.0E-4f);
    public static final Preset tertiaryVal = new Preset(1.1f, 0.92f, 5.0E-4f);
    public static final Preset marginVal = new Preset(4.2f, 0.9f, 6.0E-4f);
    public static final Preset weightVal = new Preset(3.0f, 0.9f, 8.0E-4f);
    public static final Preset paramVal = new Preset(4.4f, 0.9f, 6.0E-4f);
    public static final Preset extraVal = new Preset(7.6f, 0.5f, 8.0E-4f);
    public static final Preset limitVal = new Preset(3.6f, 0.55f, 6.0E-4f);
    public static final Preset speedVal = new Preset(4.0f, 0.62f, 6.0E-4f);
    public static final Preset widthVal = new Preset(2.05f, 0.6f, 6.0E-4f);
    public static final Preset chunkVal = new Preset(1.6f, 1.0f, 8.0E-4f);
    public static final Preset blockRef = new Preset(2.8f, 1.0f, 5.0E-4f);
    public static final Preset holderVal = new Preset(3.4f, 0.86f, 6.0E-4f);
    public static final Preset timerVal = new Preset(5.2f, 0.84f, 8.0E-4f);
    public static final Preset anchorVal = new Preset(4.0f, 0.8f, 8.0E-4f);
    public static final Preset weightRef = new Preset(2.6f, 0.82f, 8.0E-4f);
    public static final Preset bufferVal = new Preset(0.9f, 1.0f, 0.0015f);
    public static final Preset countVal = new Preset(0.7f, 1.0f, 0.0015f);
    public static final Preset depthVal = new Preset(0.8f, 1.0f, 0.0015f);
    public static final Preset descRef = new Preset(1.4f, 1.0f, 0.0015f);
    public static final Preset activeVal = new Preset(3.6f, 0.95f, 4.0E-4f);
    public static final Preset radiusVal = new Preset(1.6f, 0.85f, 6.0E-4f);
    public static final Preset factorVal = new Preset(1.35f, 0.92f, 6.0E-4f);
    public static final Preset sourceVal = new Preset(4.6f, 0.78f, 8.0E-4f);
    public static final Preset extraRef = new Preset(5.4f, 0.86f, 8.0E-4f);
    public static final Preset phaseVal = new Preset(4.8f, 0.86f, 8.0E-4f);
    public static final Preset limitRef = new Preset(5.0f, 0.62f, 8.0E-4f);

    private SpringPresets() {
    }

    public record Preset(float frequencyHz, float dampingRatio, float settleDistance) {
    }
}

