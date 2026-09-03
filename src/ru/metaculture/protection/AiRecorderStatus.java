/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public record AiRecorderStatus(String text, boolean training, boolean loadingModel, long queuedRecords, long writtenRecords, long droppedRecords, long updatedAtMs) {
    public static AiRecorderStatus idle() {
        return new AiRecorderStatus("AI idle", false, false, 0L, 0L, 0L, System.currentTimeMillis());
    }
}

