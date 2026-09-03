/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public class NumberLerp {
    public static <T extends Number> T primaryVal(T t, T t2, double d) {
        double d2 = t.doubleValue();
        double d3 = t2.doubleValue();
        double d4 = d2 + d * (d3 - d2);
        if (t instanceof Integer) {
            return (T)Integer.valueOf((int)Math.round(d4));
        }
        if (t instanceof Double) {
            return (T)Double.valueOf(d4);
        }
        if (t instanceof Float) {
            return (T)Float.valueOf((float)d4);
        }
        if (t instanceof Long) {
            return (T)Long.valueOf(Math.round(d4));
        }
        if (t instanceof Short) {
            return (T)Short.valueOf((short)Math.round(d4));
        }
        if (t instanceof Byte) {
            return (T)Byte.valueOf((byte)Math.round(d4));
        }
        throw new IllegalArgumentException("Unsupported type: " + t.getClass().getSimpleName());
    }
}

