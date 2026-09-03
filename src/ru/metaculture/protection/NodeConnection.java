/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Objects;

public final class NodeConnection {
    private final String primaryVal;
    private final String secondaryVal;
    private final String tertiaryVal;
    private final String marginVal;

    public NodeConnection(String string, String string2, String string3, String string4) {
        this.primaryVal = Objects.requireNonNull(string, "fromNodeId");
        this.secondaryVal = Objects.requireNonNull(string2, "fromPinId");
        this.tertiaryVal = Objects.requireNonNull(string3, "toNodeId");
        this.marginVal = Objects.requireNonNull(string4, "toPinId");
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public String secondaryVal() {
        return this.secondaryVal;
    }

    public String tertiaryVal() {
        return this.tertiaryVal;
    }

    public String marginVal() {
        return this.marginVal;
    }

    public String weightVal() {
        return this.primaryVal + "." + this.secondaryVal;
    }

    public String paramVal() {
        return this.tertiaryVal + "." + this.marginVal;
    }
}

