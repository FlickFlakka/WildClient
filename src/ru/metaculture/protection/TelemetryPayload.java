/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.UUID;

public final class TelemetryPayload {
    public String primaryVal;
    public String secondaryVal;
    public long tertiaryVal;
    public boolean marginVal;
    public long weightVal;
    public int paramVal;
    public int extraVal;
    public String limitVal;

    public static TelemetryPayload primaryVal() {
        TelemetryPayload spanB = new TelemetryPayload();
        spanB.primaryVal = UUID.randomUUID().toString();
        spanB.secondaryVal = "wild-1.21.8-1787661348375";
        spanB.tertiaryVal = System.currentTimeMillis() / 1000L;
        spanB.marginVal = false;
        spanB.weightVal = 0L;
        spanB.paramVal = 0;
        spanB.extraVal = 0;
        spanB.limitVal = "";
        return spanB;
    }
}

