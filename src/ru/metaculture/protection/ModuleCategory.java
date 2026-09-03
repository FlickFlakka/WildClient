/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public enum ModuleCategory {
    Combat("Combat", "f"),
    Movement("Movement", "b"),
    Visuals("Visuals", "n"),
    Player("Player", "m"),
    Misc("Misc", "v");
    private final String primaryVal;
    private final String secondaryVal;
    ModuleCategory(String string2, String string3) {
        this.primaryVal = string2;
        this.secondaryVal = string3;
    }

    public String primaryVal() {
        return this.secondaryVal;
    }

    public String secondaryVal() {
        return this.primaryVal;
    }

}

