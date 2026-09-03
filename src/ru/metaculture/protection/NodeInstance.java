/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class NodeInstance {
    private final String primaryVal;
    private final String secondaryVal;
    private float tertiaryVal;
    private float marginVal;
    private float weightVal;
    private final Map<String, Float> paramVal = new LinkedHashMap<String, Float>();
    private final Map<String, String> extraVal = new LinkedHashMap<String, String>();

    public NodeInstance(String string, String string2, float f, float f2) {
        this.primaryVal = Objects.requireNonNull(string, "id");
        this.secondaryVal = Objects.requireNonNull(string2, "kind");
        this.tertiaryVal = f;
        this.marginVal = f2;
        this.weightVal = 188.0f;
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public String secondaryVal() {
        return this.secondaryVal;
    }

    public float tertiaryVal() {
        return this.tertiaryVal;
    }

    public float marginVal() {
        return this.marginVal;
    }

    public void primaryVal(float f, float f2) {
        this.tertiaryVal = f;
        this.marginVal = f2;
    }

    public float weightVal() {
        return this.weightVal;
    }

    public void primaryVal(float f) {
        this.weightVal = Math.max(132.0f, f);
    }

    public Map<String, Float> paramVal() {
        return this.paramVal;
    }

    public Map<String, String> extraVal() {
        return this.extraVal;
    }

    public float primaryVal(String string, float f) {
        Float f2;
        block3: {
            block2: {
                f2 = this.paramVal.get(string);
                if (f2 == null) break block2;
                if (Float.isFinite(f2.floatValue())) break block3;
            }
            return f;
        }
        return f2.floatValue();
    }

    public void secondaryVal(String string, float f) {
        if (string != null && Float.isFinite(f)) {
            this.paramVal.put(string, Float.valueOf(f));
        }
    }

    public String primaryVal(String string, String string2) {
        String string3 = this.extraVal.get(string);
        if (string3 == null || string3.isBlank()) {
            return string2;
        }
        return string3;
    }

    public void secondaryVal(String string, String string2) {
        if (string != null) {
            this.extraVal.put(string, string2 == null ? "" : string2);
        }
    }
}

