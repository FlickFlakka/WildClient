/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public class EventPriority {
    public static final byte HIGHEST = 0;
    public static final byte HIGH = 1;
    public static final byte NORMAL = 2;
    public static final byte LOW = 3;
    public static final byte LOWEST = 4;
    public static final byte[] ORDER;

    static {
        byte[] byArray = new byte[5];
        byArray[0] = 0;
        byArray[1] = 1;
        byArray[2] = 2;
        byArray[3] = 3;
        byArray[4] = 4;
        ORDER = byArray;
    }
}
