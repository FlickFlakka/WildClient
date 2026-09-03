/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.UniformType;
import ru.metaculture.protection.PortDirection;

public record NodePort(String id, String label, UniformType type, PortDirection direction, String defaultExpression) {
    public static NodePort input(String string, String string2, UniformType baseF, String string3) {
        return new NodePort(string, string2, baseF, PortDirection.INPUT, string3);
    }

    public static NodePort output(String string, String string2, UniformType baseF) {
        return new NodePort(string, string2, baseF, PortDirection.OUTPUT, "");
    }
}

