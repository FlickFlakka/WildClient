/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.TelemetryPayload;
import ru.metaculture.protection.TelemetryStateStore;

public final class TelemetrySaveGate {
    private static final long primaryVal = 300L;
    private static final long secondaryVal = Long.getLong("wild.guard.stateSaveIntervalSeconds", 60L);
    private static volatile long tertiaryVal;

    private TelemetrySaveGate() {
    }

    public static void primaryVal(long l) {
        TelemetryPayload spanB = TelemetryStateStore.primaryVal();
        if (spanB.tertiaryVal > 0L && l + 300L < spanB.tertiaryVal) {
            return;
        }
        if (l > spanB.tertiaryVal && l - Math.max(spanB.tertiaryVal, tertiaryVal) >= secondaryVal) {
            spanB.tertiaryVal = l;
            spanB.secondaryVal = "wild-1.21.8-1787661348375";
            TelemetryStateStore.primaryVal(spanB);
            tertiaryVal = l;
        }
    }
}

