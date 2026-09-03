/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public enum UniformType {
    FLOAT("float", 1),
    VEC2("vec2", 2),
    VEC3("vec3", 3),
    VEC4("vec4", 4),
    INT("int", 1);
    private final String primaryVal;
    private final int secondaryVal;
    private UniformType(String string2, int n2) {
        this.primaryVal = string2;
        this.secondaryVal = n2;
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public int secondaryVal() {
        return this.secondaryVal;
    }}

