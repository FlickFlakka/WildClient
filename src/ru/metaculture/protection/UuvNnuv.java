/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public enum UuvNnuv {
    TRUE,
    FALSE,
    UNKNOWN;
public static UuvNnuv primaryVal(boolean bl, boolean bl2, Boolean bl3) {
        if (!bl) {
            return FALSE;
        }
        if (!bl2 || bl3 == null) {
            return UNKNOWN;
        }
        return bl3 != false ? TRUE : FALSE;
    }

    public boolean primaryVal() {
        return this == FALSE;
    }}

