/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public enum AnimDirection {
    FORWARDS,
    BACKWARDS;
public AnimDirection primaryVal() {
        if (this == FORWARDS) {
            return BACKWARDS;
        }
        return FORWARDS;
    }}

