/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class SpringPhysicsParams {
    private final float primaryVal;
    private final float secondaryVal;

    private SpringPhysicsParams(float f, float f2) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("frequencyHz must be > 0");
        }
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("dampingRatio must be > 0");
        }
        this.primaryVal = f;
        this.secondaryVal = f2;
    }

    public static SpringPhysicsParams primaryVal(float f, float f2) {
        return new SpringPhysicsParams(f, f2);
    }

    public float primaryVal() {
        return this.primaryVal;
    }

    public float secondaryVal() {
        return this.secondaryVal;
    }
}

